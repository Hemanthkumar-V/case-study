package com.casestudy.categoryservice.common;

import java.util.List;

public class TransactionResponse {
	private Product[] product;


	public TransactionResponse(Product[] productResponse) {
		super();
		this.product = productResponse;
	}

	public TransactionResponse(List<Product> productResponse) {
		// TODO Auto-generated constructor stub
	}

	public Product[] getProduct() {
		return product;
	}

	public void setProduct(Product[] product) {
		this.product = product;
	}
	

}