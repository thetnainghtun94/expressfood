package com.ExpressFood.Food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.ExpressFood.Food.entity.Category;

@EnableJpaRepositories
@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer>{
	
	public Category findByCategoryName(String categoryName);

}
