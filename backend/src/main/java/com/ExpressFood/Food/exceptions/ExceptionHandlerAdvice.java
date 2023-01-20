package com.ExpressFood.Food.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {
	
	@ExceptionHandler(value = MenuNotExistException.class)
	public final ResponseEntity<String> handleMenuNotExistException(MenuNotExistException exception){
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	

}
