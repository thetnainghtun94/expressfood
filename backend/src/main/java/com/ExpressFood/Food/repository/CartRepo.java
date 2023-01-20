package com.ExpressFood.Food.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.ExpressFood.Food.entity.Cart;
import com.ExpressFood.Food.entity.User;

@EnableJpaRepositories
@Repository
public interface CartRepo extends JpaRepository<Cart,Integer>{
	
	List<Cart> findAllByUserOrderByCreatedDateDesc(User user);
	
	List<Cart> deleteByUser(User user);

}
