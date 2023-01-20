package com.ExpressFood.Food.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ExpressFood.Food.config.MessageStrings;
import com.ExpressFood.Food.dto.ResponseDto;
import com.ExpressFood.Food.dto.user.SignInDto;
import com.ExpressFood.Food.dto.user.SignInResponseDto;
import com.ExpressFood.Food.dto.user.SignupDto;
import com.ExpressFood.Food.dto.user.UserCreateDto;
import com.ExpressFood.Food.entity.AuthenticationToken;
import com.ExpressFood.Food.entity.ResponseStatus;
import com.ExpressFood.Food.entity.Role;
import com.ExpressFood.Food.entity.User;
import com.ExpressFood.Food.exceptions.AuthenticationFailException;
import com.ExpressFood.Food.exceptions.CustomException;
import com.ExpressFood.Food.repository.UserRepo;
import com.ExpressFood.Food.utils.Helper;

//import static com.ExpressFood.Food.config.MessageStrings.USER_CREATED;

@Service
public class UserServiceImpl {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	AuthenticationService  authenticationService;
	
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	public ResponseDto signUp(SignupDto signupDto) throws CustomException{
		//check current email has already register
		if(Helper.notNull(userRepo.findByEmail(signupDto.getEmail()))) {
			//email has been register throw an exception
			throw new CustomException("User already exists");
		}
		
		//first encrypt password
		String encryptedPassword = signupDto.getPassword();
		try {
			encryptedPassword = hashPassword(signupDto.getPassword());
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
			logger.error("hashing password failed {}",e.getMessage());
		}
		
		User user  = new User(signupDto.getName(),signupDto.getEmail(),Role.user,encryptedPassword);
		
		User createdUser;
		try {
			//save the user
			createdUser = userRepo.save(user);
			//generate token for user
			final AuthenticationToken  authenticationToken  = new AuthenticationToken(createdUser);
			//save token in database
			authenticationService.saveConfirmationToken(authenticationToken);
			//success in creating
			  return new ResponseDto(ResponseStatus.success.toString());
			
		}catch(Exception e) {
			//handle signup error
			throw new CustomException(e.getMessage());
		}
	}
		
	
	//.............SignInResponse
	public SignInResponseDto signIn(SignInDto signInDto) throws CustomException{
		//find user by email
		User user  = userRepo.findByEmail(signInDto.getEmail());
		if(!Helper.notNull(user)) {
			throw new AuthenticationFailException("usesr not present");
		}
		try {
			//check password is right
			if(!user.getPassword().equals(hashPassword(signInDto.getPassword()))) {
				throw new AuthenticationFailException(MessageStrings.WRONG_PASSWORD);
			
			}
		}catch(NoSuchAlgorithmException  e) {
			logger.error("hashing password failed{}",e.getMessage());
			throw new CustomException(e.getMessage());	
		}
		
		AuthenticationToken token = authenticationService.getToken(user);
		
		if(!Helper.notNull(token)) {
			//token not present
			throw new CustomException("token not present");
		}
		return new SignInResponseDto("success",token.getToken());
	}
	
	private String hashPassword(String password) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		byte[] digest = md.digest();
		String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
		return myHash;
	}
	
	//.......Create User
	
	public ResponseDto createUser(String token,UserCreateDto userCreateDto) throws  CustomException,
	AuthenticationFailException{
		User creatingUser  = authenticationService.getUser(token);
		if(!canCrudUser(creatingUser.getRole())) {
			//user cannot create new user
			throw new AuthenticationFailException(MessageStrings.USER_NOT_PERMITTED);
		}
		String encryptedPassword = userCreateDto.getPassword();
		try {
			encryptedPassword = hashPassword(userCreateDto.getPassword());
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
			logger.error("hashing password failed {}",e.getMessage());
		}
		
		User user  = new User(userCreateDto.getName(),userCreateDto.getEmail(),
				userCreateDto.getRole(),encryptedPassword);
		User createdUser;
		try {
			createdUser = userRepo.save(user);
			final AuthenticationToken authenticationToken = new AuthenticationToken(createdUser);
			authenticationService.saveConfirmationToken(authenticationToken);
			return new ResponseDto(ResponseStatus.success.toString());		
		}catch(Exception e) {
			//handle user creation fail error
			throw new CustomException(e.getMessage());
		}
		
	}


	boolean canCrudUser(Role role) {
		if(role == Role.admin) {
			return true;
		}
		return false;
	}
	
	boolean canCrudUser(User userUpdating,Integer userIdBeingUpdated) {
		Role role = userUpdating.getRole();
		//admin can crud user
		if(role == Role.admin) {
			return true;
		}
		//user can update his own record,but not his role
		if(role == Role.user && userUpdating.getId() == userIdBeingUpdated) {
			return true;
		}
		return false;
		
	}
	
	

	}
