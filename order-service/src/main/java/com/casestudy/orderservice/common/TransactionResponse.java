package com.casestudy.orderservice.common;

import com.casestudy.orderservice.entity.Order;

public class TransactionResponse {
 private Order order;
 private int amount;
 private String transactionId;
 private String message;
 
 public TransactionResponse()
 {
	 
 }
public TransactionResponse(Order order, int amount, String transactionId, String message) {
	super();
	this.order = order;
	this.amount = amount;
	this.transactionId = transactionId;
	this.message = message;
}
public Order getOrder() {
	return order;
}
public void setOrder(Order order) {
	this.order = order;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
public String getTransactionId() {
	return transactionId;
}
public void setTransactionId(String transactionId) {
	this.transactionId = transactionId;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
 

}
