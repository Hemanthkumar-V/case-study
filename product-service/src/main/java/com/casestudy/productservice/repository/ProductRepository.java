package com.casestudy.productservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.productservice.entiry.Product;
@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {


	public List<Product> getByProductCategory(String productCategory);
	
	public List<Product> getProductByPrice(double price);

	
	
	
	
	

}
