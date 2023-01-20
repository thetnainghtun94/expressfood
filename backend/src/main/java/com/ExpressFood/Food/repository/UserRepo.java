package com.ExpressFood.Food.repository;




//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.ExpressFood.Food.entity.User;

@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<User,Integer>{
	
//	public List<User> findAll(User user);
	
	public User findByEmail(String email);
	
	public User findUserByEmail(String email);

}
