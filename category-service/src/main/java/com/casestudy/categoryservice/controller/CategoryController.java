package com.casestudy.categoryservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.categoryservice.entity.Category;
import com.casestudy.categoryservice.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	@GetMapping("/helloCategory")
	public String helloCategory()
	{
		return "Hello category";
		
	}
	@PostMapping("/addCategory")
	public Category addCategory(@RequestBody Category category)
	{
		return categoryService. addCategory(category);
	}
	
//	@GetMapping("/getCategorywithProduct")
//	public  TransactionResponse getCategoryWithProduct(String categoryName)
//	{
//		return categoryService. getCategoryWithProduct(categoryName);
//		
//	}
	
	
	@GetMapping("/getAllCategory")
	public List<Category> getAllCategory(Category category)
	{
		return  categoryService.getAllCategory(category);
		
	}
	@GetMapping("/getById/{id}")
	public Optional<Category> getcategoryById(@PathVariable("id") int id)
	{
		return  categoryService. getcategoryById(id);
		
	}
	
	@PutMapping("/updatecategory/{id}")
	public Category updateCategory(@PathVariable("id") int id,@RequestBody Category category)
	{
		return categoryService.updateCategory(id,category);
		
	}
	
	@DeleteMapping("/deleteCategory/{id}")
	public void deleteCategory(@PathVariable("id") int id)
	{
		categoryService.deleteCategory(id);
	}
	


}
