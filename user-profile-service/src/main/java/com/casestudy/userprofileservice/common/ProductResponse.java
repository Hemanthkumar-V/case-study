package com.casestudy.userprofileservice.common;

import java.util.List;

public class ProductResponse {
	private int statusCode;
	private String statusMassage;
	private String appName;
	private int port;
	
	private List<Product> products;
	private Product product;
	public ProductResponse()
	{
		
	}
	
	public ProductResponse(int statusCode, String statusMassage, String appName, int port, List<Product> products,
			Product product) {
		super();
		this.statusCode = statusCode;
		this.statusMassage = statusMassage;
		this.appName = appName;
		this.port = port;
		this.products = products;
		this.product = product;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMassage() {
		return statusMassage;
	}

	public void setStatusMassage(String statusMassage) {
		this.statusMassage = statusMassage;
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
		
	}


