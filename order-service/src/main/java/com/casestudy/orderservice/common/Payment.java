package com.casestudy.orderservice.common;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


public class Payment {

	private int paymentId;

	private String paymentStatus;

	private String TransactionId;
	
	private  int orderId;
	private int amount;
	
	public Payment()
	{
		
	}
	
	public Payment(int paymentId, String paymentStatus, String transactionId, int orderId, int amount) {
		super();
		this.paymentId = paymentId;
		this.paymentStatus = paymentStatus;
		TransactionId = transactionId;
		this.orderId = orderId;
		this.amount = amount;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getTransactionId() {
		return TransactionId;
	}

	public void setTransactionId(String transactionId) {
		TransactionId = transactionId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	

	
	
	

	
	
	
	

}
