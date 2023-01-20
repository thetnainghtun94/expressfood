package com.ExpressFood.Food.service;

import java.util.List;
import java.util.Optional;

import com.ExpressFood.Food.entity.Category;

public interface CategoryService {
	
	public Category createCategory(Category category);
	
	public List<Category> listCategory();
	
	public Category get(Integer id);
	
	public Category updateCategory(Integer id,Category updateCategory);
	
	public boolean delete(Integer id);
	
	public Category readCategory(String categoryName) ;
	
	public Optional<Category> readCategory(Integer categoryId);



}
