package com.casestudy.orderservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.orderservice.common.TransactionResponse;
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
  @PostMapping("/saveOrder")
	public  TransactionResponse bookOrder(@RequestBody Order order)
	{
	 
		return orderService.saveOrder(order);
	}
  
  @GetMapping("/getOrders")
  		public List<Order> getAllOrders(Order order)
  		{
			return  orderService.getAllOrders(order);
	  
  		}
  
  @GetMapping("/getOrder/{id}")
  
 public Optional<Order> getOredrById(@PathVariable("id") int oId)
 {
	  return orderService.getOrderById(oId);  
	  
 }
   @GetMapping("/deleteOrder/{id}")
   public void deleteOrderById(@PathVariable("id") int oId)
   {
	   orderService.deleteOrderById(oId);
   }
}
