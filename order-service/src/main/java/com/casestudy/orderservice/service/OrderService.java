package com.casestudy.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.orderservice.entity.Order;
import com.casestudy.orderservice.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	public Order saveOrder(Order order)
	{
		return orderRepository.save(order);
	}

}
