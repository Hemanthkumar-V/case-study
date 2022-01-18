package com.casestudy.orderservice.entity;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("order")
public class Order {
@Id
private int orderId;
@Field
private int userId;
@Field
private String userame;
@Field
private int ProductId;
@Field
private String  productName;
@Field
private double productPrice;
@Field
private int qty;
@Field
private double orderPrice;
@Field
private String ShippingAddress;
@Field
private String PaymentType;
public Order()
{
	
}
public Order(int orderId, int userId, String userame, int productId, String productName, double productPrice, int qty,
		double orderPrice, String shippingAddress, String paymentType) {
	super();
	this.orderId = orderId;
	this.userId = userId;
	this.userame = userame;
	ProductId = productId;
	this.productName = productName;
	this.productPrice = productPrice;
	this.qty = qty;
	this.orderPrice = orderPrice;
	ShippingAddress = shippingAddress;
	PaymentType = paymentType;
}
public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getUserame() {
	return userame;
}
public void setUserame(String userame) {
	this.userame = userame;
}
public int getProductId() {
	return ProductId;
}
public void setProductId(int productId) {
	ProductId = productId;
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
public int getQty() {
	return qty;
}
public void setQty(int qty) {
	this.qty = qty;
}
public double getOrderPrice() {
	return orderPrice;
}
public void setOrderPrice(double orderPrice) {
	this.orderPrice = orderPrice;
}
public String getShippingAddress() {
	return ShippingAddress;
}
public void setShippingAddress(String shippingAddress) {
	ShippingAddress = shippingAddress;
}
public String getPaymentType() {
	return PaymentType;
}
public void setPaymentType(String paymentType) {
	PaymentType = paymentType;
}
public String getCurrency() {
	// TODO Auto-generated method stub
	return null;
}

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Document("order")
//public class Order {
//
//	private int orderId;
//	@Field
//	private String  orderName;
//	@Field
//	private int qty;
//	@Field
//	private int orderPrice;
//	
//	public Order()
//	{
//		
//	}
//
//	public Order(int orderId, String orderName, int qty, int orderAmount) {
//		super();
//		this.orderId = orderId;
//		this.orderName = orderName;
//		this.qty = qty;
//		this.orderPrice = orderPrice;
//	}
//
//	public int getOrderId() {
//		return orderId;
//	}
//
//	public void setOrderId(int orderId) {
//		this.orderId = orderId;
//	}
//
//	public String getOrderName() {
//		return orderName;
//	}
//
//	public void setOrderName(String orderName) {
//		this.orderName = orderName;
//	}
//
//	public int getQty() {
//		return qty;
//	}
//
//	public void setQty(int qty) {
//		this.qty = qty;
//	}
//
//	public int getOrderPrice() {
//		return orderPrice;
//	}
//
//	public void setOrderPrice(int orderPrice) {
//		this.orderPrice = orderPrice;
//	}

	

	
	}

	

	

	

