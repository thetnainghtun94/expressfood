package com.ExpressFood.Food.controller;

import java.util.List;

import com.ExpressFood.Food.dto.*;
import com.ExpressFood.Food.dto.user.SignInDto;
import com.ExpressFood.Food.dto.user.SignInResponseDto;
import com.ExpressFood.Food.dto.user.SignupDto;
import com.ExpressFood.Food.exceptions.AuthenticationFailException;
import com.ExpressFood.Food.exceptions.CustomException;
import com.ExpressFood.Food.entity.User;
import com.ExpressFood.Food.repository.UserRepo;
import com.ExpressFood.Food.service.AuthenticationService;
import com.ExpressFood.Food.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/user")
@RestController
public class UserController {
	
	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	AuthenticationService authenticationService;
	
	@Autowired
	UserRepo userRepo;
	
	@GetMapping("/all")
	public List<User> findAllUser(@RequestParam("token") String token) throws AuthenticationFailException{
		authenticationService.authenticate(token);
		return userRepo.findAll();
	}
	
	@PostMapping("/signup")
	public ResponseDto Signup(@RequestBody SignupDto signupDto) throws CustomException{
		return userService.signUp(signupDto);
	}
	
	@PostMapping("/signIn")
	public SignInResponseDto Signup(@RequestBody SignInDto signInDto) throws CustomException{
		return userService.signIn(signInDto);
		
	}
	
//	@Autowired	
//	PasswordEncoder pwEncoder;
	
//	@GetMapping("/user")
//	public List<User> listUser(){
//		return userService.getAll();
//	}
//	
//	@PostMapping("/login")
//	public ResponseEntity<User> login(@Valid @RequestBody LoginRequest lognReq){
//		User user  = userService.checkLoginUser(lognReq.getGmail(), lognReq.getPassword());
//		if(user == null) {
//			return ResponseEntity.badRequest().build();
//		}
//		return ResponseEntity.ok().body(user);	
//	}
//	
//	@PostMapping("/register")
//	public ResponseEntity<?> register(@Valid @RequestBody User user){
//		User createdUser = userService.create(user);
//		if(createdUser == null) {
//			return ResponseEntity.badRequest().body("User with same gmail already exists!");
//		}
//		return ResponseEntity.ok().body(createdUser);
//	}
//	
//	@GetMapping("/profile")
//	public ResponseEntity<User> getProfile(@RequestParam int id){
//		User user = userService.get(id);
//		if(user == null) {
//			return ResponseEntity.notFound().build();
//		}
//		return ResponseEntity.ok().body(user);	
//	}
//	
//	@PostMapping("/changePassword")
//	public ResponseEntity<Object> changePassword(@Valid @RequestBody ChangePassword changePwd) throws IOException{
//		User user  = userService.get(changePwd.getOri_id());
//		if(user == null) {
//			return new ResponseEntity<Object>(
//					new Exception("Something Wrong"),HttpStatus.CONFLICT);
//		}
//		if(!changePwd.getCon_new_pwd().equals(changePwd.getNew_pwd())) {
//			return new ResponseEntity<Object>(
//					new Exception("Confirm Password does not match"),
//					HttpStatus.CONFLICT);
//		}
//		if (!pwEncoder
//				.matches(changePwd.getCurrent_pwd(), user.getPassword())) {
//			return new ResponseEntity<Object>(
//					new Exception("Current Password does not match"),
//					HttpStatus.CONFLICT
//			);	
//	}
//	userService.updatePwd(user.getUser_id(),changePwd.getNew_pwd());
//	return ResponseEntity.ok().body(user);
//	}
//	
//	@PostMapping("/profile/update")
//	public ResponseEntity<User> updateProfile(@Valid @RequestBody User user){
//		if (user.getUser_id() <= 0) {
//			return ResponseEntity.badRequest().build();
//		}
//		User updatedUser = userService.update(user.getUser_id(), user);
//		if (updatedUser == null) {
//			return ResponseEntity.notFound().build();
//		}
//		return ResponseEntity.ok().body(updatedUser);
//		
//	}
	
}
