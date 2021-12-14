package com.casestudy.categoryservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.casestudy.categoryservice.common.Product;
import com.casestudy.categoryservice.common.TransactionResponse;
import com.casestudy.categoryservice.entity.Category;
import com.casestudy.categoryservice.feign.ProductProxy;
import com.casestudy.categoryservice.repository.CategoryRepisitory;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepisitory categoryRepository;
//	@Autowired
	//private ProductProxy productProxy;
	@Autowired
	private  RestTemplate restTemplate;
  
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


//	public TransactionResponse getAllProductsByCategoryName(String categoryName)
//	{
//		Product product=new Product();
//		Category category=new Category();
//		
//		List<Product> response= (List<Product>) productProxy.getAllProductsByCategoryName();
//		return new TransactionResponse(category.getCategoryName(),response);
//	}
//
//







	









//	public TransactionResponse getAllProduct() {
//		Product product=new Product();
//		Category category=new Category();
//		
//		List<Product> response= (List<Product>) productProxy.getAllProducts();
//		return new TransactionResponse(response);
//	
//	}






	public TransactionResponse getCategoryWithProduct(@PathVariable String  productCategory)
	{

		Product product=new Product();
//		Category category=new Category();
//		product.setProductCategory(categoryName);
		Product[] productResponse=restTemplate.getForObject("http://localhost:8081/product/getProducts/"+productCategory, Product[].class);
		
		return new TransactionResponse(productResponse);
	}
			

	public TransactionResponse getAllProducts() 
	{
		Product product=new Product();
		Product[] productResponse=restTemplate.getForObject("http://localhost:8081/product/getProducts", Product[].class);
		
		return new TransactionResponse(productResponse);
	}









	
}







	
			
	
	

	
	
	
	


