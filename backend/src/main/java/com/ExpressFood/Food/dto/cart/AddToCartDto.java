package com.ExpressFood.Food.dto.cart;

public class AddToCartDto {
	
	private Integer id;
	private Integer menuId;
	private Integer quantity;

	
	public AddToCartDto() {	
		
	}

//	public AddToCartDto(Integer id, Integer menuId, Integer quantity) {
//		super();
//		this.id = id;
//		this.menuId = menuId;
//		this.quantity = quantity;
//	}

	public Integer getId() {
		return id;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "AddToCartDto [id=" + id + ", menuId=" + menuId + ", quantity=" + quantity + "]";
	}


}
