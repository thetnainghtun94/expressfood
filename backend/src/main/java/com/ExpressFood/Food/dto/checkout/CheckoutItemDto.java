package com.ExpressFood.Food.dto.checkout;

public class CheckoutItemDto {

	private String menuName;
	private int quantity;
	private double price;
	private long menuId;
	private int userId;

	public CheckoutItemDto() {
		
	}

	public CheckoutItemDto(String menuName, int quantity, double price, long menuId, int userId) {
		super();
		this.menuName = menuName;
		this.quantity = quantity;
		this.price = price;
		this.menuId = menuId;
		this.userId = userId;
	}

	public String getMenuName() {
		return menuName;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getPrice() {
		return price;
	}

	public long getMenuId() {
		return menuId;
	}

	public int getUserId() {
		return userId;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "CheckoutItemDto [menuName=" + menuName + ", quantity=" + quantity + ", price=" + price + ", menuId="
				+ menuId + ", userId=" + userId + "]";
	}
	
	
	
	
}
