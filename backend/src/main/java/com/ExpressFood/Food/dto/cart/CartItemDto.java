package com.ExpressFood.Food.dto.cart;

import com.ExpressFood.Food.entity.Cart;
import com.ExpressFood.Food.entity.Menu;

public class CartItemDto {
	
	private Integer id;
	private Integer quantity;
	private Menu menu;
	
	public CartItemDto() {
		
	}
	
	public CartItemDto(Cart cart) {
		this.setId(cart.getId());
		this.setQuantity(cart.getQuantity());
		this.setMenu(cart.getMenu());
		
	}

	public Integer getId() {
		return id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	@Override
	public String toString() {
		return "CartItemDto [id=" + id + ", quantity=" + quantity + ", menu=" + menu + "]";
	}

	


}
