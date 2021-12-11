package com.casestudy.userprofileservice.common;

public class TransactionResponse {
	private Product[] product;

	public TransactionResponse(Product[] productResponse) {
		super();
		this.product = productResponse;
	}

	public Product[] getProduct() {
		return product;
	}

	public void setProduct(Product[] product) {
		this.product = product;
	}
	

}
