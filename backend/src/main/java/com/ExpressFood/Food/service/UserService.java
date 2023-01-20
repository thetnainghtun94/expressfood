package com.ExpressFood.Food.service;

import com.ExpressFood.Food.dto.ResponseDto;
import com.ExpressFood.Food.dto.user.SignInDto;
import com.ExpressFood.Food.dto.user.SignInResponseDto;
import com.ExpressFood.Food.dto.user.SignupDto;
import com.ExpressFood.Food.dto.user.UserCreateDto;
import com.ExpressFood.Food.entity.Role;
import com.ExpressFood.Food.entity.User;

public interface UserService {

	public ResponseDto signUp(SignupDto signupDto);
	
	public SignInResponseDto signIn(SignInDto signInDto);
	
//	private String hashPassword(String password);
	
	public ResponseDto createUser(String token,UserCreateDto userCreateDto);
	
	boolean canCrudUser(Role role);
	
	boolean canCrudUser(User userUpdating,Integer userIdBeingUpdated);
}
