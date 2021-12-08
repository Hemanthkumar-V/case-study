package com.casestudy.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.productservice.entiry.Product;
@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {

}
