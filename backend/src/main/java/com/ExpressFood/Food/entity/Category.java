package com.ExpressFood.Food.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


import lombok.ToString;

@Entity
@ToString
@Table(name = "categories")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	
	@Column(length = 50)
	@NotBlank(message = "Required")
	private String categoryName;
	
	@Column(length = 1000)
	@NotBlank(message = "Required")
	private String image;
	
	@OneToMany(mappedBy = "category",fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	Set<Menu> menus; 
	public Category() {
	
	}
	public Category(Integer id, @NotBlank(message = "Required") String categoryName,
			@NotBlank(message = "Required") String image) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.image = image;
	}

	public Integer getId() {
		return id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public String getImage() {
		return image;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setImage(String image) {
		this.image = image;
	}


	 
	

	
   
}
