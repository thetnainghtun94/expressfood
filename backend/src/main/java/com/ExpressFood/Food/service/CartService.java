package com.ExpressFood.Food.service;

import com.ExpressFood.Food.dto.cart.AddToCartDto;
import com.ExpressFood.Food.dto.cart.CartDto;
import com.ExpressFood.Food.dto.cart.CartItemDto;
import com.ExpressFood.Food.entity.Cart;
import com.ExpressFood.Food.entity.Menu;
import com.ExpressFood.Food.entity.User;


public interface CartService {
	
	
	public void addToCart(AddToCartDto addToCartDto,Menu menu,User user); //1

	public CartDto listCartItems(User user); //2
	
	public CartItemDto getDtoFromCart(Cart cart) ;//3
	
	public void updateCartItem(AddToCartDto cartDto, User user,Menu menu);

//	public void deleteCartItem(Integer cartItemId, User user);
	public void deleteCartItem(int id,int userId);
	
	public void deleteCartItems(int userId);
	 
	public void deleteUserCartItems(User user) ;
	


	


}
