package com.casestudy.cartservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.casestudy.cartservice.common.Product;
import com.casestudy.cartservice.common.ResponseTemplateVo;
import com.casestudy.cartservice.entity.CartItem;
import com.casestudy.cartservice.repository.CartRepository;

@Service
public class CartService {
	
	@Autowired
	private CartRepository cartRepository;
	
	
	

	public CartItem addToCart(CartItem cartItem) {
		
		return cartRepository.insert(cartItem);
	}

	public List<CartItem> getAllCartItems() {
		
		return cartRepository.findAll() ;
	}

	public CartItem getByCartId(int cartId) {
		
		List<CartItem>cartItembyId= cartRepository.findAll();
		CartItem cartItems=null;
		for(CartItem cartItem:cartItembyId)
		{
			if(cartItem.getCartId()==cartId)
				cartItems=cartItem;
		}
		return cartItems;
		
		
	}

	public CartItem updateCart(CartItem cartItem) {
		
		return cartRepository.save(cartItem);
	}

	public String deleteCartItem(int id) {
		
		 cartRepository.deleteById(id); 
		 return "Item deleted from cart succefully";
	}


		
		
	

}
