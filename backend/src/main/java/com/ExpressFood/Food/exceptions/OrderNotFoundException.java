package com.ExpressFood.Food.exceptions;

public class OrderNotFoundException extends IllegalArgumentException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderNotFoundException(String msg) {
        super(msg);
    }
}
