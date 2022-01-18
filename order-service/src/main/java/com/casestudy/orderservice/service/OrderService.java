package com.casestudy.orderservice.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.orderservice.entity.Order;
import com.casestudy.orderservice.repository.OrderRepository;
import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
//	@Autowired
//	private RestTemplate restTemplate;
//	
	public Order saveOrder(Order order)
{

		return orderRepository.insert(order);
		
		
}
	

	public List<Order> getAllOrders(Order order) {
		
		return orderRepository.findAll();
	}
	
	public Order getOrderById(int oId)
	{
		List<Order>order=orderRepository.findAll();
		Order order1=null;
		for(Order orderById:order)
		{
			if(orderById.getOrderId()==oId)
			{
				order1=orderById;
			}
		}
		return order1;
	}
	
public Order updateOrder(Order order) {
		
		return orderRepository.save(order);
	}


	public void deleteOrderById(int oId) {
		
		 orderRepository.deleteById(oId);
	}

	
	
	
	
	
	@Autowired
	private APIContext apiContext;


	public Payment createPayment(
			Double total, 
			String i, 
			String method,
			String intent,
			String description, 
			String cancelUrl, 
			String successUrl) throws PayPalRESTException{
		Amount amount = new Amount();
		amount.setCurrency(i);
		total = new BigDecimal(total).setScale(2, RoundingMode.HALF_UP).doubleValue();
		amount.setTotal(String.format("%.2f", total));

		Transaction transaction = new Transaction();
		transaction.setDescription(description);
		transaction.setAmount(amount);

		List<Transaction> transactions = new ArrayList<>();
		transactions.add(transaction);

		Payer payer = new Payer();
		payer.setPaymentMethod(method.toString());

		Payment payment = new Payment();
		payment.setIntent(intent.toString());
		payment.setPayer(payer);  
		payment.setTransactions(transactions);
		RedirectUrls redirectUrls = new RedirectUrls();
		redirectUrls.setCancelUrl(cancelUrl);
		redirectUrls.setReturnUrl(successUrl);
		payment.setRedirectUrls(redirectUrls);

		return payment.create(apiContext);
	}

	public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException{
		Payment payment = new Payment();
		payment.setId(paymentId);
		PaymentExecution paymentExecute = new PaymentExecution();
		paymentExecute.setPayerId(payerId);
		return payment.execute(apiContext, paymentExecute);
	}





		
	}

	


	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//String message="";
//		
//		  Payment payment=new Payment();
//		  payment.setOrderId(order.getOrderId());
//		  payment.setAmount(order.getOrderPrice()*order.getQty());
//		  
//		  //rest call
//		Payment paymentResponce= restTemplate.postForObject("http://localhost:8087/wallet/dopayment/", payment, Payment.class);
//		  
//		message=paymentResponce.getPaymentStatus().equals("success")?"payment processing successfull and order places":"payment failure item added to cart";
		
//		return new TransactionResponse(order,paymentResponce.getAmount(),paymentResponce.getTransactionId(),message);
	








































	
	


