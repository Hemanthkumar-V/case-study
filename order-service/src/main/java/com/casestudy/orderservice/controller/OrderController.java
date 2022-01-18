package com.casestudy.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.orderservice.entity.Order;
import com.casestudy.orderservice.service.OrderService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	
	@GetMapping("/place")
	public String placeOrder()
	{
		return "i palced the order";
	}
  @PostMapping("/saveOrder")
	public  Order bookOrder(@RequestBody Order order)
	{
	 
		return orderService.saveOrder(order);
	}
  
  @GetMapping("/getOrders")
  		public List<Order> getAllOrders(Order order)
  		{
			return  orderService.getAllOrders(order);
	  
  		}
  
  @GetMapping("/getOrder/{id}")
  
 public Order getOredrById(@PathVariable("id") int oId)
 {
	  return orderService.getOrderById(oId);  
	  
 }
  
  @PutMapping("/updateOrder/{id}")
  public Order updateOrder(@PathVariable("id")int id, @RequestBody Order order)
  {
  order.setOrderId(order.getOrderId());
	 return orderService.updateOrder(order);
  }
   @GetMapping("/deleteOrder/{id}")
   public void deleteOrderById(@PathVariable("id") int oId)
   {
	   orderService.deleteOrderById(oId);
   }
   
   
   

		

		public static final String SUCCESS_URL = "pay/success";
		public static final String CANCEL_URL = "pay/cancel";

		@GetMapping("/")
		public String home() {
			return "home";
		}

		@PostMapping("/pay")
		public String payment(@ModelAttribute("order") Order order) {
			try {
				Payment payment = orderService.createPayment(order.getOrderPrice(), order.getShippingAddress(), order.getPaymentType(),
						order.getProductName(), order.getProductName(), "http://localhost:8086/" + CANCEL_URL,
						"http://localhost:8086/" + SUCCESS_URL);
				for(Links link:payment.getLinks()) {
					if(link.getRel().equals("approval_url")) {
						return "redirect:"+link.getHref();
					}
				}

			} catch (PayPalRESTException e) {

				e.printStackTrace();
			}
			return "redirect:/";
		}

		 @GetMapping(value = CANCEL_URL)
		    public String cancelPay() {
		        return "cancel";
		    }

		    @GetMapping(value = SUCCESS_URL)
		    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
		        try {
		            Payment payment = orderService.executePayment(paymentId, payerId);
		            System.out.println(payment.toJSON());
		            if (payment.getState().equals("approved")) {
		                return "success";
		            }
		        } catch (PayPalRESTException e) {
		         System.out.println(e.getMessage());
		        }
		        return "redirect:/";
		    }

}





