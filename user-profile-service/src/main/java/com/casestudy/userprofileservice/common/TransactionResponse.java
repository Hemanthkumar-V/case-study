package com.casestudy.userprofileservice.common;

import java.util.List;

import com.casestudy.userprofileservice.entity.UserProfile;

public class TransactionResponse {
	private int statusCode;
	private String statusMassage;
	private String appName;
	private int port;
	private List<UserProfile>users;
	private List<Product> product;
	private Product product1;

	public TransactionResponse()
	{
		
	}

	



	public Product getProduct1() {
		return product1;
	}





	public void setProduct1(Product product1) {
		this.product1 = product1;
	}





	public TransactionResponse(int statusCode, String statusMassage, String appName, int port, List<UserProfile> users,
			List<Product> product, Product product1) {
		super();
		this.statusCode = statusCode;
		this.statusMassage = statusMassage;
		this.appName = appName;
		this.port = port;
		this.users = users;
		this.product = product;
		this.product1 = product1;
	}





	public TransactionResponse(List<Product> products) {
		this.product=products;
	}



	public TransactionResponse(UserProfile user, String msg) {
		this.users=(List<UserProfile>) user;
		this.statusMassage=msg;
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

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}



	public List<UserProfile> getUsers() {
		return users;
	}



	public void setUsers(List<UserProfile> users) {
		this.users = users;
	}

	
	}
	


