package com.ExpressFood.Food.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ExpressFood.Food.entity.Category;
import com.ExpressFood.Food.repository.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepo categoryRepo;
	
	@Override
	public Category createCategory(Category category) {
		return categoryRepo.save(category);
	}

	@Override
	public List<Category> listCategory() {
		return categoryRepo.findAll();
	}
	
	@Override
	public Category get(Integer id) {
		return categoryRepo.findById(id).orElse(null);
	}

	@Override
	public Category updateCategory(Integer id, Category updateCategory) {
		Category toUpdateCategory = this.get(id);
		if(toUpdateCategory == null) {
			return null;
		}
		toUpdateCategory.setCategoryName(updateCategory.getCategoryName());
		toUpdateCategory.setImage(updateCategory.getImage());
		categoryRepo.save(toUpdateCategory);
		return toUpdateCategory;
	}

//	@Override
//	public boolean delete(Integer id) {
//		Category category = this.get(id);
//		if(category == null) {
//			return false;
//		}
//		categoryRepo.deleteById(id);
//		return true;
//	}

	@Override
	public Category readCategory(String categoryName) {	
		return categoryRepo.findByCategoryName(categoryName);
	}

	@Override
	public Optional<Category> readCategory(Integer categoryId) {
		System.out.println("Category Id"+categoryId);
		return categoryRepo.findById(categoryId);
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}
	

	

}
