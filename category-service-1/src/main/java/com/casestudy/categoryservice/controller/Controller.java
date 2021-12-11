package com.casestudy.categoryservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/swag")
public class Controller {
	@GetMapping("/helliSwag")
	public String helloSwag()
	{
		return "HelloSwag";
		
	}
	
	@PostMapping("/post")
	public String helloPost()
	{
		return "post";
	}
	

}
