//package com.ExpressFood.Food.controller;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import com.ExpressFood.Food.common.ApiResponse;
//import com.ExpressFood.Food.dto.cart.AddToCartDto;
//import com.ExpressFood.Food.dto.cart.CartDto;
//import com.ExpressFood.Food.entity.Menu;
//import com.ExpressFood.Food.entity.User;
//import com.ExpressFood.Food.exceptions.AuthenticationFailException;
//import com.ExpressFood.Food.exceptions.CartItemNotExistException;
//import com.ExpressFood.Food.exceptions.MenuNotExistException;
//import com.ExpressFood.Food.service.AuthenticationService;
//import com.ExpressFood.Food.service.CartService;
//import com.ExpressFood.Food.service.MenuService;
//
//import javax.validation.Valid;
//
//@RestController
//@RequestMapping("/cart")
//public class CartController {
//    @Autowired
//    private CartService cartService;
//
//    @Autowired
//    private MenuService menuService;
//
//    @Autowired
//    private AuthenticationService authenticationService;
//
//    @PostMapping("/add")
//    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto,
//                                                 @RequestParam("token") String token) throws AuthenticationFailException, MenuNotExistException {
//        authenticationService.authenticate(token);
//        User user = authenticationService.getUser(token);
//        Menu product = menuService.getMenuById(addToCartDto.getMenuId());
//        System.out.println("product to add"+  product.getName());
//        cartService.addToCart(addToCartDto, product, user);
//        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);
//
//    }
//    @GetMapping("/")
//    public ResponseEntity<CartDto> getCartItems(@RequestParam("token") String token) throws AuthenticationFailException {
//        authenticationService.authenticate(token);
//        User user = authenticationService.getUser(token);
//        CartDto cartDto = cartService.listCartItems(user);
//        return new ResponseEntity<CartDto>(cartDto,HttpStatus.OK);
//    }
//    @PutMapping("/update/{cartItemId}")
//    public ResponseEntity<ApiResponse> updateCartItem(@RequestBody @Valid AddToCartDto cartDto,
//                                                      @RequestParam("token") String token) throws AuthenticationFailException,MenuNotExistException {
//        authenticationService.authenticate(token);
//        User user = authenticationService.getUser(token);
//        Menu menu = menuService.getMenuById(cartDto.getMenuId());
//        cartService.updateCartItem(cartDto, user,menu);
//        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been updated"), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/delete/{cartItemId}")
//    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") int itemID,@RequestParam("token") String token) throws AuthenticationFailException, CartItemNotExistException {
//        authenticationService.authenticate(token);
//        int userId = authenticationService.getUser(token).getUser_id();
//        cartService.deleteCartItem(itemID, userId);
//        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Item has been removed"), HttpStatus.OK);
//    }
//
//}


package com.ExpressFood.Food.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ExpressFood.Food.common.ApiResponse;
import com.ExpressFood.Food.dto.cart.AddToCartDto;
import com.ExpressFood.Food.dto.cart.CartDto;
import com.ExpressFood.Food.entity.Menu;
import com.ExpressFood.Food.entity.User;
import com.ExpressFood.Food.exceptions.AuthenticationFailException;
import com.ExpressFood.Food.exceptions.CartItemNotExistException;
import com.ExpressFood.Food.exceptions.MenuNotExistException;
import com.ExpressFood.Food.service.AuthenticationService;
import com.ExpressFood.Food.service.CartService;
import com.ExpressFood.Food.service.MenuService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	AuthenticationService authenticationService;

	
	@PostMapping("/add")
	public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto,
			@RequestParam("token") String token) throws AuthenticationFailException,MenuNotExistException{
		authenticationService.authenticate(token);
		//find User
		System.out.println(addToCartDto);
		User user = authenticationService.getUser(token);
		System.out.println(user);
		Menu menu = menuService.getMenuById(addToCartDto.getMenuId());
		System.out.println("menu is add"+menu.getName());
		cartService.addToCart(addToCartDto, menu,user);
		  return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);
//		if(addToCartDto.getUser() == null) {			
//			return ResponseEntity.badRequest().body("User  is Empty");
}

	@GetMapping("/")
	public ResponseEntity<CartDto> getCartItems(@RequestParam("token") String token){
		authenticationService.authenticate(token);
			//find User
		User user  = authenticationService.getUser(token);
			//get cart items
		CartDto cartDto = cartService.listCartItems(user);
			 return new ResponseEntity<CartDto>(cartDto,HttpStatus.OK);
	}
		
	@PutMapping("/update/{cartItemId}")
	public ResponseEntity<ApiResponse> updateCartItem(@RequestBody @Valid AddToCartDto cartDto,
			@RequestParam("token") String token) throws AuthenticationFailException,MenuNotExistException{
		authenticationService.authenticate(token);
		//find User
		User user  = authenticationService.getUser(token);
		Menu menu = menuService.getMenuById(cartDto.getMenuId());
		cartService.updateCartItem(cartDto, user, menu);
		 return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Menu has been updated"), HttpStatus.OK);
		
	}
		
	@DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") int itemID,@RequestParam("token") String token) throws AuthenticationFailException, CartItemNotExistException {
        authenticationService.authenticate(token);
        int userId = authenticationService.getUser(token).getId();
        cartService.deleteCartItem(itemID, userId);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Item has been removed"), HttpStatus.OK);
    }
			


	
	//post cart Api
//	@PostMapping("/add")
//	public ResponseEntity<?> addToCart(@RequestBody AddToCartDto addToCartDto){
//		if(addToCartDto.get)
//		
		
		//return null;
		//find user
//	 cartService.addToCart(addToCartDto,user);
//	    return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);
//		
	
	
	
	//get all cart items for user
	
	//delete a cart item for user

}
