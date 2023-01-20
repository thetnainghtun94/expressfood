package com.ExpressFood.Food.dto;


import javax.validation.constraints.NotNull;

import com.ExpressFood.Food.entity.Menu;

public class MenuDto {
	
	private Integer id;
	private @NotNull String name;
	private @NotNull String image;
	private @NotNull double price;
	private @NotNull String description;
	private @NotNull Integer categoryId;
	
	public MenuDto(@NotNull Integer id, @NotNull String name, @NotNull String image, @NotNull double price, @NotNull String description, @NotNull Integer categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.price = price;
		this.description = description;
		this.categoryId = categoryId;
	}
	
	public MenuDto(Menu menu) {
		this.setid(menu.getId());
		this.setName(menu.getName());
		this.setImage(menu.getImage());
		this.setDescription(menu.getDescription());
		this.setPrice(menu.getPrice());
		this.setCategoryId(menu.getCategory().getId());
	}
	
	public Integer getid() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getImage() {
		return image;
	}
	public double getPrice() {
		return price;
	}
	public String getDescription() {
		return description;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setid(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "MenuDto [id=" + id + ", name=" + name + ", image=" + image + ", price=" + price + ", description="
				+ description + ", categoryId=" + categoryId + "]";
	}

//	@Override
//	public String toString() {
//		return "MenuDto [id=" + id + ", name=" + name + ", image=" + image + ", price=" + price
//				+ ", description=" + description + ", categoryId=" + categoryId + "]";
//	}
	
	
	
}
