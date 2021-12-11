package com.casestudy.cartservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("cartItem")
public class CartItem {
	@Id
	private int cartId; 
	@Field
	private int productId;
	
	@Field
	private double totalPrice;
	
	public CartItem()
	{
		
	}
	
	public CartItem(int cartId, int productId, double totalPrice) {
		super();
		this.cartId = cartId;
		this.productId = productId;
		this.totalPrice = totalPrice;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}


	
	
	
	
	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}


	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	
	
	
	

}
