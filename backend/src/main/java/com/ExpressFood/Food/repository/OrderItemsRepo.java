package com.ExpressFood.Food.repository;

import com.ExpressFood.Food.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemsRepo extends JpaRepository<OrderItem,Integer> {
}
