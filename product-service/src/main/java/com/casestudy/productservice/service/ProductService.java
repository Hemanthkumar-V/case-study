package com.casestudy.productservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.productservice.entiry.Product;
import com.casestudy.productservice.repository.ProductRepository;
@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public Product saveProduct(Product product) {
		
		return productRepository.save(product);
	}

	public List<Product> getProduct(Product product) {
		
		return productRepository.findAll();
	}

	public Optional<Product> getProductById(int productId) {
		
		return productRepository.findById(productId);
	}

	public void deleteProductById(int productId) {
		
		 productRepository.deleteById(productId);
	}

}
