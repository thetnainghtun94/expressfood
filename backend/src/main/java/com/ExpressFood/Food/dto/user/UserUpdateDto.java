package com.ExpressFood.Food.dto.user;

public class UserUpdateDto {
	
	private Integer user_id;
	private String name;
	private String role;
	
	public Integer getUser_id() {
		return user_id;
	}
	public String getName() {
		return name;
	}
	public String getRole() {
		return role;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
