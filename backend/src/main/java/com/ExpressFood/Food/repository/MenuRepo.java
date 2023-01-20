package com.ExpressFood.Food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.ExpressFood.Food.entity.Menu;

@EnableJpaRepositories
@Repository
public interface MenuRepo extends JpaRepository<Menu,Integer>{
	

}
