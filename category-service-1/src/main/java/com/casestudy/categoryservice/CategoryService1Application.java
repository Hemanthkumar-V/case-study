package com.casestudy.categoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CategoryService1Application {

	public static void main(String[] args) {
		SpringApplication.run(CategoryService1Application.class, args);
	}

}
