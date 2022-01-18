package com.casestudy.cartservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("cartItem")
public class CartItem {
	@Id
	private int cartId; 
	@Field
	private int userId;
	@Field
	private int productId;
	@Field
	private String productName;
	@Field 
	private double productPrice;
	@Field
	private int productQty;
	@Field
	private double totalcostofeachproduct;
	@Field
	private double totalPrice;
	
	public CartItem()
	{
		
	}
	
	

	



	public CartItem(int cartId, int userId, int productId, String productName, double productPrice, int productQty,
			double totalcostofeachproduct, double totalPrice) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQty = productQty;
		this.totalcostofeachproduct = totalcostofeachproduct;
		this.totalPrice = totalPrice;
	}







	public int getCartId() {
		return cartId;
	}



	public void setCartId(int cartId) {
		this.cartId = cartId;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public int getProductId() {
		return productId;
	}



	public void setProductId(int productId) {
		this.productId = productId;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public double getProductPrice() {
		return productPrice;
	}



	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}



	public int getProductQty() {
		return productQty;
	}



	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}



	public double getTotalcostofeachproduct() {
		return totalcostofeachproduct;
	}


public void setTotalcostofeachproduct(double totalcostofeachproduct) {
		this.totalcostofeachproduct = totalcostofeachproduct;
	}



public double getTotalPrice() {
		return totalPrice;
	}



	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	
	
	
	

}
