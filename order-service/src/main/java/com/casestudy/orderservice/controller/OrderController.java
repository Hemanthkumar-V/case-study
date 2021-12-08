package com.casestudy.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.orderservice.entity.Order;
import com.casestudy.orderservice.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	
	@GetMapping("/place")
	public String placeOrder()
	{
		return "i palced the order";
	}
  @PostMapping("/save")
	public  Order bookOrder(@RequestBody Order order)
	{
		return orderService.saveOrder(order);
	}
}
