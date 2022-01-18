package com.casestudy.orderservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.orderservice.entity.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, Integer>{
	
	public Order getOrderByOrderPrice(double orderPrice);

}
