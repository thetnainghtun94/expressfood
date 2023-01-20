package com.ExpressFood.Food.exceptions;

public class MenuNotExistException extends IllegalArgumentException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MenuNotExistException(String msg) {
		super(msg);
	}

}
