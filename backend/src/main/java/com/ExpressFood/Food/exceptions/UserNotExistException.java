package com.ExpressFood.Food.exceptions;

public class UserNotExistException extends IllegalArgumentException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserNotExistException(String msg) {
		 super(msg);
	}

}
