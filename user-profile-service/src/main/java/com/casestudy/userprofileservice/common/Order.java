package com.casestudy.userprofileservice.common;

import org.springframework.data.mongodb.core.mapping.Field;

public class Order {
	
	private int orderId;
	
	private int userId;
	
	private String userame;
	
	private int ProductId;
	
	private String  productName;
	
	private double productPrice;
	
	private int qty;
	
	private double orderPrice;
	
	private String ShippingAddress;
	private String PaymentType;
	
	public Order()
	{
	}
	

	public Order(int orderId, int userId, String userame, int productId, String productName, double productPrice,
			int qty, double orderPrice, String shippingAddress, String paymentType) {
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
	
	
	


	

}
