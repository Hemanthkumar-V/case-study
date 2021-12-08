package com.casestudy.orderservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("order")
public class Order {
	@Id
	private int oId;
	private String  oName;
	private int qty;
	private double price;

}
