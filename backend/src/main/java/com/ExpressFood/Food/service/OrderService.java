package com.ExpressFood.Food.service;

import java.util.List;



import com.ExpressFood.Food.dto.checkout.CheckoutItemDto;
import com.ExpressFood.Food.entity.Order;
import com.ExpressFood.Food.entity.User;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;


public interface OrderService {

	SessionCreateParams.LineItem.PriceData createPriceData(CheckoutItemDto checkoutItemDto);
	
	SessionCreateParams.LineItem createSessionLineItem(CheckoutItemDto checkoutItemDto);
	
	public Session createSession(List<CheckoutItemDto> checkoutItemDtoList) throws StripeException;
	
	public void placeOrder(User user, String sessionId);
	
	public List<Order> listOrders(User user);
	
	public Order getOrder(Integer orderId);
}
