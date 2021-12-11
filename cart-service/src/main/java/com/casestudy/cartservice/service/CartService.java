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
	
	
	

	public CartItem saveCartItem(CartItem cartItem) {
		
		return cartRepository.save(cartItem);
	}

	public List<CartItem> getAllCartItems(CartItem cartitems) {
		
		return cartRepository.findAll() ;
	}

	public Optional<CartItem> getByCartId(int cartId) {
		
		return cartRepository.findById(cartId);
	}

	public CartItem updateCart(CartItem cartItem) {
		
		return cartRepository.save(cartItem);
	}


		
		
	

}
