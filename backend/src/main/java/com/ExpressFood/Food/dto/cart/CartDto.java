package com.ExpressFood.Food.dto.cart;

import java.util.List;

public class CartDto {
	
	private List<CartItemDto> cartItems;
	private double totalCost;
	
	public CartDto() {
		
	}

	public CartDto(List<CartItemDto> cartItems, double totalCost) {
		super();
		this.cartItems = cartItems;
		this.totalCost = totalCost;
	}



	public List<CartItemDto> getCartItems() {
		return cartItems;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setCartItems(List<CartItemDto> cartItems) {
		this.cartItems = cartItems;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
  
}
