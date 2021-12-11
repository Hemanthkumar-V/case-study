package com.casestudy.productservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.productservice.entiry.Product;
import com.casestudy.productservice.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	
	private ProductService productService;
	
	@GetMapping("/pro")
	public String getProduct()
	{
		return "iam product";
	}
	
	@PostMapping("/saveProduct")
	public Product saveProduct(@RequestBody Product product)
	{
		return productService.saveProduct(product);
		
	}
	
	@GetMapping("/getProducts")
	public List<Product> getProduct(Product product)
	{
		return  productService.getProduct(product);
	}
	
	@GetMapping("/getProduct/{id}")
	public Optional<Product> getProductById(@PathVariable("id") int productId)
	{
		return  productService.getProductById(productId);
	}
	
	@GetMapping("/getproduct/{productCategory}")
	public Product getByProductCategory(@PathVariable("productCategory") String productCategory)
	{
		return  productService.getByProductCategory(productCategory);
	}
	
	@GetMapping("/deleteProduct/{id}")
	public void deleteById(@PathVariable("id") int productId)
	{
		 productService.deleteProductById(productId);
	}
	
}
