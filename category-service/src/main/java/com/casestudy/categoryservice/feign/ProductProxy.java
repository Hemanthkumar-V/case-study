package com.casestudy.categoryservice.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.casestudy.categoryservice.common.Product;
import com.casestudy.categoryservice.common.TransactionResponse;

@FeignClient(name="PRODUCT-SERVICE",url="http://localhost:8081")
public interface ProductProxy {
	@GetMapping("/getproduct/{productCategory}")
	public TransactionResponse getAllProductsByCategoryName();
	@GetMapping("/getProducts")
	public List<Product> getAllProducts();
	
}
