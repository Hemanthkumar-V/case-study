package com.casestudy.orderservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class HelloOrder {
	@GetMapping("/place")
	public String placeOrder()
	{
		return "i palced the order";
	}

}
