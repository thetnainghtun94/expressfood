package com.ExpressFood.Food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ExpressFood.Food.dto.checkout.CheckoutItemDto;
import com.ExpressFood.Food.dto.checkout.StripeResponse;
import com.ExpressFood.Food.service.AuthenticationService;
import com.ExpressFood.Food.service.OrderServiceImpl;
//import com.ExpressFood.Food.service.OrderServiceImpl;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
//import com.stripe.net.StripeResponse;
import com.ExpressFood.Food.common.ApiResponse;
import com.ExpressFood.Food.exceptions.AuthenticationFailException;
import com.ExpressFood.Food.exceptions.OrderNotFoundException;
import com.ExpressFood.Food.entity.Order;
import com.ExpressFood.Food.entity.User;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	AuthenticationService authenticationService;

//	@Autowired
	OrderServiceImpl orderService = new OrderServiceImpl();
	
	//script session checkout
	@PostMapping("/create-checkout-session")
	public ResponseEntity<StripeResponse> checkoutList(@RequestBody List<CheckoutItemDto> checkOutItemListDto)
			throws StripeException {
		// create the stripe session
		System.out.println("hello world");
		
		Session session = orderService.createSession(checkOutItemListDto);
		System.out.println("something");
		StripeResponse stripeResponse = new StripeResponse(session.getId());
		System.out.println("Hello" + stripeResponse);
		// send the stripe session id in response
		return new ResponseEntity<StripeResponse>(stripeResponse, HttpStatus.OK);

	}
	
	// place order after checkout
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> placeOrder(@RequestParam("token") String token, @RequestParam("sessionId") String sessionId)
            throws AuthenticationFailException {
        // validate token
        authenticationService.authenticate(token);
        // retrieve user
        User user = authenticationService.getUser(token);
        // place the order
        orderService.placeOrder(user, sessionId);
        return new ResponseEntity<>(new ApiResponse(true, "Order has been placed"), HttpStatus.CREATED);
    }

    // get all orders
    @GetMapping("/")
    public ResponseEntity<List<Order>> getAllOrders(@RequestParam("token") String token) throws AuthenticationFailException {
        // validate token
        authenticationService.authenticate(token);
        // retrieve user
        User user = authenticationService.getUser(token);
        // get orders
        List<Order> orderDtoList = orderService.listOrders(user);

        return new ResponseEntity<>(orderDtoList, HttpStatus.OK);
    }


    // get orderitems for an order
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOrderById(@PathVariable("id") Integer id, @RequestParam("token") String token)
            throws AuthenticationFailException {
        // validate token
        authenticationService.authenticate(token);
        try {
            Order order = orderService.getOrder(id);
            return new ResponseEntity<>(order,HttpStatus.OK);
        }
        catch (OrderNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }

}
