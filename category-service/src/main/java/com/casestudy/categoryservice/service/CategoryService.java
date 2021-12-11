package com.casestudy.categoryservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.casestudy.categoryservice.entity.Category;
import com.casestudy.categoryservice.repository.CategoryRepisitory;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepisitory categoryRepository;
	@Autowired
	private RestTemplate restTemplate;
  
	public Category addCategory(Category category) 
	{
		
		return categoryRepository.save(category);
		
	}
	
		
	 
	
		
	
	
	
	
	public List<Category> getAllCategory(Category category)
	{
		return categoryRepository.findAll();
		
	}

	public Optional<Category> getcategoryById(int id) {
		
		return categoryRepository.findById(id);
	}

	public void deleteCategory(int id) {
		
		categoryRepository.deleteById(id);
	}

	

	public Category updateCategory(int id, Category category) {
		// TODO Auto-generated method stub
		return categoryRepository.save(category);
	}








//
//	public TransactionResponse getCategoryWithProduct(String categoryName)
//	{
//		
//			
//				Product product= new Product();
//				Category category=new Category();
//			
//				List<Product> productResponse=(List<Product>) restTemplate.postForObject("http://localhost:8081/product/getproduct/electronic",product,Product.class );
//				for(Product listofProduct:productResponse)
//					{
//					productResponse.add(listofProduct);
//					}
//	
//				return new TransactionResponse(category.getCategoryName(),productResponse);
//			
//	}
//				
	
	}

	
	
	
	


