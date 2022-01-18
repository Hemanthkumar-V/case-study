
package com.casestudy.productservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.productservice.common.TransactionRequest;
import com.casestudy.productservice.common.TransactionResponse;
import com.casestudy.productservice.entiry.Product;
import com.casestudy.productservice.service.ProductService;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	
	private ProductService productService;
	
	@GetMapping("/pro")
	public String getProduct1()
	{
		return "iam product";
	}
	@PostMapping("/saveProduct")
	public TransactionResponse saveProduct(@RequestBody TransactionRequest request)
	{
		TransactionResponse response=new TransactionResponse();
		
	try{
		String msg= productService.saveProduct(request);
	
		response.setStatusCode(200);
		response.setStatusMassage(msg);
		response.setAppName("Product-Service");
		response.setPort(8082);
	}
	catch(Exception e)
	{
		String msg= productService.saveProduct(request);
		
		response.setStatusCode(400);
		response.setStatusMassage(msg);
		response.setAppName("Product-Service");
		response.setPort(8082);
	}
	return response;
	}
	
	@GetMapping("/getProducts")
	public List<Product> getProduct()
	{
	return	productService.getProduct();
	}
//	{
//		TransactionResponse response=new TransactionResponse();
//		
//	try
//	{
//		List<Product> allproduct= productService.getProduct();
//		
//		response.setStatusCode(200);
//		response.setStatusMassage("Successfully fetched the data");
//		response.setAppName("Product-Service");
//		response.setPort(8082);
//		response.setProducts(allproduct);
//	}
//	catch(Exception e)
//	{
//		response.setStatusCode(400);
//		response.setStatusMassage("Exception occured while fetching the product");
//		response.setAppName("Product-Service");
//		response.setPort(8082);
//		
//	}
	
	
	@GetMapping("/getProduct/{productId}")
	public Product getProductById(@PathVariable("productId") int productId)
	{
		return productService.getProductById(productId);
	}
//		TransactionResponse response= new TransactionResponse();
//		
//	try
//	{
//	
//		Product product= productService.getProductById(productId);
//		
//		response.setStatusCode(200);
//		response.setStatusMassage("Successfully fetched the data");
//		response.setAppName("Product-Service");
//		response.setPort(8082);
//		response.setProduct(product);
//	}
//	catch(Exception e)
//	{
//		response.setStatusCode(400);
//		response.setStatusMassage("Exception occured while fetching the product");
//		response.setAppName("Product-Service");
//		response.setPort(8082);
//		
//	}
//	return response;
//	
	//}
	
	@GetMapping("/getproduct/{productCategory}")
	public TransactionResponse getByProductCategory(@PathVariable("productCategory") String productCategory)
	{


		TransactionResponse response= new TransactionResponse();
		
	try
	{
	
		List<Product>productsbyCategory=  productService.getByProductCategory(productCategory);
		
		response.setStatusCode(200);
		response.setStatusMassage("Successfully fetched the Products based on Category");
		response.setAppName("Product-Service");
		response.setPort(8082);
		response.setProducts(productsbyCategory);
	}
	catch(Exception e)
	{
		response.setStatusCode(400);
		response.setStatusMassage("Exception occured while fetching the product based on category");
		response.setAppName("Product-Service");
		response.setPort(8082);
		
	}
	return response;
			
	}
	
	@GetMapping("/getByPrice/{productPrice}")
	public List<Product> geyProductByPrice(@PathVariable("productPrice") double productPrice)
	{
		return productService.geyProductByPrice(productPrice);
		
	}
	
	@PutMapping("/updateProduct/{id}")
	public TransactionResponse updateProduct(@PathVariable("id") int id ,@RequestBody TransactionRequest request)
	{
		request.setProductId(id);
		String msg=productService.updateProduct(request);
		TransactionResponse response= new TransactionResponse();
		
		try
		{
		
			
			
			response.setStatusCode(200);
			response.setStatusMassage(msg);
			response.setAppName("Product-Service");
			response.setPort(8082);
			
		}
		catch(Exception e)
		{
			response.setStatusCode(400);
			response.setStatusMassage("Updation Fail");
			response.setAppName("Product-Service");
			response.setPort(8082);
			
		}
		return response;
		
	}
	
	@DeleteMapping("/deleteProduct/{productId}")
	public TransactionResponse deleteById(@PathVariable("productId") int productId)
	{
		String msg="";
		TransactionResponse response= new TransactionResponse();
		boolean success=false;
		 success=productService.deleteProductById(productId);
		 if(success)
		 {
			msg="product deleted successfully" ;
			
			response.setStatusCode(200);
			response.setStatusMassage(msg);
			response.setAppName("Product-Service");
			response.setPort(8082);
			
		}
		 else {
			response.setStatusCode(400);
			response.setStatusMassage("Exception occured while deleting the product");
			response.setAppName("Product-Service");
			response.setPort(8082);
			
		}
		return response;
		
		 }
		
	}
	

