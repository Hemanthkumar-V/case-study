package com.casestudy.cartservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hellocart")
public class Hello {
	@GetMapping("/cartItem")
	public String Hello()
	{
		return "hello cart iam hetre";
	}

}
