package com.casestudy.orderservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.casestudy.orderservice.common.Payment;
import com.casestudy.orderservice.common.TransactionResponse;
import com.casestudy.orderservice.entity.Order;
import com.casestudy.orderservice.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private RestTemplate restTemplate;
	
	public TransactionResponse saveOrder(Order order)
	{
		String message="";
		
		  Payment payment=new Payment();
		  payment.setOrderId(order.getOrderId());
		  payment.setAmount(order.getOrderPrice()*order.getQty());
		  
		  //rest call
		Payment paymentResponce= restTemplate.postForObject("http://localhost:8087/wallet/dopayment/", payment, Payment.class);
		  
		message=paymentResponce.getPaymentStatus().equals("success")?"payment processing successfull and order places":"payment failure item added to cart";
		orderRepository.save(order);
		return new TransactionResponse(order,paymentResponce.getAmount(),paymentResponce.getTransactionId(),message);
	}

	public List<Order> getAllOrders(Order order) {
		
		return orderRepository.findAll();
	}
	
	public Optional<Order> getOrderById(int oId)
	{
		return orderRepository.findById(oId);
	}

	public void deleteOrderById(int oId) {
		
		 orderRepository.deleteById(oId);
	}

}
