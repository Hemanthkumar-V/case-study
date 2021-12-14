package com.casestudy.orderservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("order")
public class Order {
@Id
	private int orderId;
	@Field
	private String  orderName;
	@Field
	private int qty;
	@Field
	private int orderPrice;
	
	public Order()
	{
		
	}

	public Order(int orderId, String orderName, int qty, int orderAmount) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
		this.qty = qty;
		this.orderPrice = orderPrice;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	

	
	}

	

	

	

