package com.casestudy.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
	@GetMapping("/pro")
	public String getProduct()
	{
		return "iam product";
	}
	

}