package com.ExpressFood.Food.service;

import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ExpressFood.Food.dto.cart.AddToCartDto;
import com.ExpressFood.Food.dto.cart.CartDto;
import com.ExpressFood.Food.dto.cart.CartItemDto;
import com.ExpressFood.Food.entity.Cart;
import com.ExpressFood.Food.entity.Menu;
import com.ExpressFood.Food.entity.User;
import com.ExpressFood.Food.exceptions.CartItemNotExistException;
import com.ExpressFood.Food.exceptions.MenuNotExistException;
import com.ExpressFood.Food.repository.CartRepo;


@Service
@Transactional
public class CartServiceImpl implements CartService{

    @Autowired
    private  CartRepo cartRepository;

    public CartServiceImpl(){}

    public CartServiceImpl(CartRepo cartRepository) {
        this.cartRepository = cartRepository;
    }
    

    public void addToCart(AddToCartDto addToCartDto, Menu menu,User user) throws MenuNotExistException {
////	//validate menuid is valid
		Menu menus = new Menu();
		Cart cart  = new Cart();
		cart.setMenu(menu);
		cart.setUser(user);
		cart.setQuantity(addToCartDto.getQuantity());
		cart.setCreatedDate(LocalDate.now());	
		cartRepository.save(cart);		
	}


    public CartDto listCartItems(User user) {
        List<Cart> cartList = cartRepository.findAllByUserOrderByCreatedDateDesc(user);
        List<CartItemDto> cartItems = new ArrayList<>();
        for (Cart cart:cartList){
            CartItemDto cartItemDto = getDtoFromCart(cart);
            cartItems.add(cartItemDto);
        }
        double totalCost = 0;
        for (CartItemDto cartItemDto :cartItems){
            totalCost += (cartItemDto.getMenu().getPrice()* cartItemDto.getQuantity());
        }
        return new CartDto(cartItems,totalCost);
    }


    public CartItemDto getDtoFromCart(Cart cart) {
        return new CartItemDto(cart);
    }


    public void updateCartItem(AddToCartDto cartDto, User user,Menu menu){
        Cart cart = cartRepository.getOne(cartDto.getId());
        cart.setQuantity(cartDto.getQuantity());
        cart.setCreatedDate(LocalDate.now());
        cartRepository.save(cart);
    }

    public void deleteCartItem(int id,int userId) throws CartItemNotExistException {
        if (!cartRepository.existsById(id))
            throw new CartItemNotExistException("Cart id is invalid : " + id);
        cartRepository.deleteById(id);

    }

    public void deleteCartItems(int userId) {
        cartRepository.deleteAll();
    }


    public void deleteUserCartItems(User user) {
        cartRepository.deleteByUser(user);
    }

//	@Override
//	public void deleteCartItem(Integer cartItemId, User user) {
//		// TODO Auto-generated method stub
//		
//	}

//	@Override
//	public void deleteCartItem(Integer cartItemId, int userId) {
//		// TODO Auto-generated method stub
//		
//	}

	
//	@Override
//	public void deleteCartItem(Integer cartItemId, User user) {
//		// TODO Auto-generated method stub
//		
//	}

//	@Override
//	public void deleteCartItem(Integer cartItemId, int userId) {
//		// TODO Auto-generated method stub
//		
//	}
}
//@Service
//public class CartServiceImpl implements CartService {
//
//		@Autowired
//		CartRepo cartRepo;
//		
//		@Autowired
//		UserRepo userRepo;
//		
//		@Autowired
//		MenuService menuService;
//			
//	@Override
////	public void addToCart(AddToCartDto addToCartDto, Menu menu,User user) {
////	//validate menuid is valid
////		Menu menus = menuService.findById(addToCartDto.getMenuId());
////		Cart cart  = new Cart();
////		cart.setMenu(menu);
////		cart.setUser(user);
////		cart.setQuantity(addToCartDto.getQuantity());
////		cart.setCreatedDate(new Date());	
////		cartRepo.save(cart);		
////	}
//	
//	public void addToCart(AddToCartDto addToCartDto, Menu menu, User user){
//        Cart cart = new Cart(menu, addToCartDto.getQuantity(), user, null);
//        cartRepo.save(cart);
//    }
//
//	@Override
//	public CartDto listCartItems(User user) {
//		List<Cart> cartList = cartRepo.findAllByUserOrderByCreatedDateDesc(user);
//		List<CartItemDto> cartItems  = new ArrayList<>();
//		for(Cart cart:cartList) {
//			CartItemDto cartItemDto = getDtoFromCart(cart);
//			cartItems.add(cartItemDto);	
//		}
//		double totalCost = 0;
//		for(CartItemDto cartItemDto:cartItems) {
//			totalCost += (cartItemDto.getMenu().getPrice()*cartItemDto.getQuantity());
//		}
//		return new CartDto(cartItems,totalCost);
//	}
//	
//
//	public CartItemDto getDtoFromCart(Cart cart) {
//		return new  CartItemDto(cart);
//	}
//
//	@Override
//	public void updateCartItem(AddToCartDto cartDto, User user, Menu menu) {
//		Cart cart  = cartRepo.getOne(cartDto.getId());
//		cart.setQuantity(cartDto.getQuantity());
//		cart.setCreatedDate(new Date());
//		cartRepo.save(cart);
//	}
//	
//	@Override
//	public void deleteCartItem(Integer cartItemId, User userId) throws CartItemNotExistException{
//		//itemid belong to user
//	if(!cartRepo.existsById(cartItemId)) throw new CartItemNotExistException("Cart id is invalid:"+ cartItemId);
//	cartRepo.deleteById(cartItemId);
////		Optional<Cart> optionalCart  = cartRepo.findById(cartItemId);	
////		if(optionalCart.isEmpty()) {
////			throw new CustomException("cart item id is invalid"+cartItemId);
////		}
////		Cart  cart = optionalCart.get();
////		if(cart.getUser() != user) {
////			throw new CustomException("cart item does not belong to user:"+cartItemId);
////		}
////		cartRepo.delete(cart);	
//	}
//
//	@Override
//	public void deleteCartItems(int userId) {
//		cartRepo.deleteAll();
//		
//	}
//
//	@Override
//	public void deleteUserCartItems(User user) {
//		cartRepo.deleteByUser(user);
//		
//	}
//	
//	
//
//	//@Override
////	public List<Cart> findAllByUser(User user) {	
////		return cartRepo.findAllByUser(user);
////	}
//
//
//}
