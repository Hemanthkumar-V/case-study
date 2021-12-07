package com.casestudy.cartservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CartItem {
	@Id
	private int cartId; 
	private String cartItems;
	

}
