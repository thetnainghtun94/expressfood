package com.ExpressFood.Food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ExpressFood.Food.entity.AuthenticationToken;
import com.ExpressFood.Food.entity.User;

@Repository
public interface TokenRepo extends JpaRepository<AuthenticationToken,Integer>{
	AuthenticationToken findTokenByUser(User user);
	AuthenticationToken  findTokenByToken(String token);

}
