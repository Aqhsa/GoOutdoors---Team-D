package com.orders.management.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.orders.management.entity.OrdersEntity;

public interface OrdersRepo extends JpaRepository <OrdersEntity, Integer>{
	
}