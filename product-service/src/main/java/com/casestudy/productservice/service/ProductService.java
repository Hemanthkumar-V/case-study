package com.casestudy.productservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.productservice.common.ProductTo;
import com.casestudy.productservice.common.TransactionRequest;
import com.casestudy.productservice.common.TransactionResponse;
import com.casestudy.productservice.entiry.Product;
import com.casestudy.productservice.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public String saveProduct(TransactionRequest request) {

		
		String msg = "";

		
			try {
			Product product = new Product();
			product.setProductId(request.getProductId());
			product.setProductName(request.getProductName());
			product.setProductCategory(request.getProductCategory());
			product.setProductType(request.getProductType());
			product.setPrice(request.getPrice());
			product.setProductDescription(request.getProductDescription());
			product.setRating(request.getRating());
			product.setReviews(request.getReviews());

			
		
		

			productRepository.save(product);
			return msg = "Product inserted succesfully";
		} catch (Exception e) {
			return msg = "Exception occured while inserting the Product";
		}
		

	}

	public List<Product> getProduct() {

		List<Product> products = productRepository.findAll();
		return products;

	}

	public Product getProductById(int productId) {

		List<Product> to = productRepository.findAll();
		Product productto = null;
		
		for(Product productById:to)
		{
			if(productById.getProductId()==productId)
			{
				productto=productById;
			}
		}
		return productto;
				

//		Optional<Product> productbyId = productRepository.findById(productId);
//		productto.setProductId(productbyId.get().getProductId());
//		productto.setProductName(productbyId.get().getProductName());
//		productto.setProductCategory(productbyId.get().getProductCategory());
//		productto.setProductType(productbyId.get().getProductType());
//		productto.setProductDescription(productbyId.get().getProductDescription());
//		productto.setPrice(productbyId.get().getPrice());
//		productto.setRating(productbyId.get().getRating());
//		productto.setReviews(productbyId.get().getReviews());
//		to.add(productto);
	//	return to;
	}

	public boolean deleteProductById(int productId) {
		boolean success = false;

		productRepository.deleteById(productId);
		success = true;
		return success;

	}

	public List<Product> getByProductCategory(String productCategory) {

		List<Product> to = new ArrayList<Product>();
		Product productto = new Product();

		List<Product> productbyCategory = (List<Product>) productRepository.getByProductCategory(productCategory);
		return productbyCategory;

	}

	public String updateProduct(TransactionRequest request) {
		String msg = "";
		Product product = new Product();
		product.setProductId(request.getProductId());
		product.setProductName(request.getProductName());
		product.setProductCategory(request.getProductCategory());
		product.setProductType(request.getProductType());
		product.setProductDescription(request.getProductDescription());
		product.setPrice(request.getPrice());
		product.setRating(request.getRating());
		product.setReviews(request.getReviews());

		try {
			productRepository.save(product);
			msg = "product updated succefully";
		} catch (Exception e) {
			msg = "exception occured while updating the product";
		}
		return msg;
	}

	public List<Product> geyProductByPrice(double productPrice) {
		
		return productRepository.getProductByPrice(productPrice);
		
	}

	
	}


