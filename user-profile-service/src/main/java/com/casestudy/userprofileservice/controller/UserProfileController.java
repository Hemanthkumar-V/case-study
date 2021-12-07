package com.casestudy.userprofileservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserProfileController {
	@RequestMapping("/hemanth")
	public String getUser()
	{
		return "hello hemanth";
	}

}
