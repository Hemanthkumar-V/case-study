package com.casestudy.cartservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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

import com.casestudy.cartservice.entity.CartItem;
import com.casestudy.cartservice.repository.CartRepository;
import com.casestudy.cartservice.service.CartService;
@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes = {ServiceMokitoTests.class})
public class ServiceMokitoTests {
	 @Mock
	 private CartRepository cartRepository;
      @InjectMocks
     CartService cartService;
      public List<CartItem> mycart;
      
      @Test 
      @Order(1)
      public void test_getAllCart()
      {
    	  List<CartItem>mycart=new ArrayList<CartItem>();
    	  mycart.add(new CartItem(1,1,1,"television",1000,2,2000,2000));
    	  mycart.add(new CartItem(2,1,1,"telephone",2000,2,4000,8000));
    	  
    	  
    	  when(cartRepository.findAll()).thenReturn(mycart);
    	 assertEquals(2,cartService.getAllCartItems().size());
      }
      @Test
      @Order(2)
      public void test_getCartById()
      {
    	  List<CartItem>mycart=new ArrayList<CartItem>();
    	  mycart.add(new CartItem(1,1,1,"television",1000,2,2000,2000));
    	  mycart.add(new CartItem(2,1,1,"telephone",2000,2,4000,8000));
    	  int cartId=1;
    	  
    	  when(cartRepository.findAll()).thenReturn(mycart);
    	  assertEquals(cartId, cartService.getByCartId(cartId).getCartId());
      }
      
      @Test
      @Order(3)
      public void test_addToCart()
      {
    	  CartItem newCartItem=new CartItem(3,3,1,"fridge",10000,1,10000,10000);
    	
    	  
    	  when(cartRepository.insert(newCartItem)).thenReturn(newCartItem);
    	  assertEquals(newCartItem, cartService.addToCart(newCartItem));
      }

      @Test
      @Order(4)
      public void test_updateCart()
      {
    	  CartItem newCartItem=new CartItem(3,4,1,"fridge",10000,1,10000,10000);
    	
    	  
    	  when(cartRepository.save(newCartItem)).thenReturn(newCartItem);
    	  assertEquals(newCartItem, cartService.updateCart(newCartItem));
      }
      
      @Test
      @Order(5) 
      public void test_deleteItemFromCart()
      {
    	  CartItem newCartItem=new CartItem(3,4,1,"fridge",10000,1,10000,10000);
    	int cartId=3;
    	  
    	
    	   cartService.deleteCartItem(cartId);
    	   verify(cartRepository,times(1)).deleteById(cartId);
      }


}
