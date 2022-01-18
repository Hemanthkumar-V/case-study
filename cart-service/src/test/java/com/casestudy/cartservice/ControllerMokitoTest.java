package com.casestudy.cartservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.casestudy.cartservice.controller.CartController;
import com.casestudy.cartservice.entity.CartItem;
import com.casestudy.cartservice.service.CartService;
@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes = {ControllerMokitoTest.class} )
public class ControllerMokitoTest {
	
	@Mock
	CartService cartService;
	
	@InjectMocks
	CartController cartController;
	List<CartItem>mycartItem;
	
	CartItem cartItem;
	@Test
	@Order(1)
	public void test_getAllCartItems()
	{
	mycartItem= new ArrayList<CartItem>();
	mycartItem.add(new CartItem(1,1,1,"television",1000,2,2000,2000));
	mycartItem.add(new CartItem(2,1,1,"telephone",2000,2,4000,8000));
	  
	  
		when(cartService.getAllCartItems()).thenReturn(mycartItem ); 
		List<CartItem> reponse=cartController.getAllCartItems();
		assertEquals(2,reponse.size() );
	}
	
	@Test
	@Order(2)
	public void test_getCartById()
	{
		cartItem=new CartItem(3,1,1,"telephone",4000,4,16000,16000);
		int cartId=3;
				when(cartService.getByCartId(cartId)).thenReturn(cartItem ); 
				CartItem reponse=cartController.getByCartId(cartId);
				assertEquals(3,reponse.getCartId() );
	}
	
	@Test
	@Order(3)
	public void test_addItemToCart()
	{
		cartItem=new CartItem(3,1,1,"telephone",4000,4,16000,16000);
		
				when(cartService.addToCart(cartItem)
				).thenReturn(cartItem ); 
				CartItem reponse=cartController.addToCart(cartItem);
				assertEquals(cartItem,reponse );
	}
	
	@Test
	@Order(4)
	public void test_updateCartItem()
	{
		cartItem=new CartItem(3,1,1,"telephone",4000,4,16000,16000);
		 int cartId=3;
				when(cartService.updateCart(cartItem)
				).thenReturn(cartItem ); 
				CartItem reponse=cartController.updateCart(cartId,cartItem);
				assertEquals(cartItem,reponse );
	}
	
	

}
