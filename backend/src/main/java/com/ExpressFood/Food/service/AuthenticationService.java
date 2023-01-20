package com.ExpressFood.Food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ExpressFood.Food.config.MessageStrings;
import com.ExpressFood.Food.entity.AuthenticationToken;
import com.ExpressFood.Food.entity.User;
import com.ExpressFood.Food.exceptions.AuthenticationFailException;
import com.ExpressFood.Food.repository.TokenRepo;
import com.ExpressFood.Food.utils.Helper;

@Service
public class AuthenticationService {
	
	@Autowired
	TokenRepo tokenRepo;
	
	public void saveConfirmationToken(AuthenticationToken authenticationToken) {
		tokenRepo.save(authenticationToken);
	}
	
	public AuthenticationToken getToken(User user) {
		return tokenRepo.findTokenByUser(user);	
	}
	
	public User getUser(String token) {
		AuthenticationToken authenticationToken = tokenRepo.findTokenByToken(token);
		if(Helper.notNull(authenticationToken)) {
			if(Helper.notNull(authenticationToken.getUser())) {
				return authenticationToken.getUser();
			}
		}
		return null;	
	}
	public void authenticate(String token) throws AuthenticationFailException{
		if(!Helper.notNull(token)) {
			throw new AuthenticationFailException(MessageStrings.AUTH_TOEKN_NOT_PRESENT);
		}
		if(!Helper.notNull(getUser(token))) {
			throw new AuthenticationFailException(MessageStrings.AUTH_TOEKN_NOT_VALID);
		}
		
	}

}
