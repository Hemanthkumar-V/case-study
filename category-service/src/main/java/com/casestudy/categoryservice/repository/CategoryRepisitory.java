package com.casestudy.categoryservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.categoryservice.entity.Category;
@Repository
public interface CategoryRepisitory extends MongoRepository<Category, Integer> {
//
//	TransactionResponse getCategoryWithProduct(String categoryName);

	

	

	

}
