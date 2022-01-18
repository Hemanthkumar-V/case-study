package com.casestudy.productservice.common;

import java.util.List;

import com.casestudy.productservice.entiry.Product;

public class TransactionResponse {
	private int statusCode;
	private String statusMassage;
	private String appName;
	private int port;
	
	private List<Product> products;
	private Product product ;
	public TransactionResponse()
	{
		
	}
	
	
	
	


	public TransactionResponse(int statusCode, String statusMassage, String appName, int port, List<Product> products,
			Product product) {
		super();
		this.statusCode = statusCode;
		this.statusMassage = statusMassage;
		this.appName = appName;
		this.port = port;
		this.products = products;
		this.product = product;
	}






	public String getStatusMassage() {
		return statusMassage;
	}
	public void setStatusMassage(String statusMassage) {
		this.statusMassage = statusMassage;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}


	public int getStatusCode() {
		return statusCode;
	}


	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}


	public String getAppName() {
		return appName;
	}


	public void setAppName(String appName) {
		this.appName = appName;
	}


	public int getPort() {
		return port;
	}


	public void setPort(int port) {
		this.port = port;
	}






	public Product getProduct() {
		return product;
	}






	public void setProduct(Product product) {
		this.product = product;
	}
	
	

}
