package com.casestudy.cartservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.cartservice.common.ResponseTemplateVo;
import com.casestudy.cartservice.entity.CartItem;
import com.casestudy.cartservice.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartService cartService;
	
	@GetMapping("/cartItem")
	public String Hello()
	{
		return "hello cart iam hetre";
	}
	
	@PostMapping("/save")
	public CartItem saveCartItem(@RequestBody CartItem cartItem)
	{
		return cartService.saveCartItem(cartItem);
		
	}
	
	@GetMapping("/getCart")
	public List<CartItem> getAllCartItems(CartItem cartItem)
	{
		return cartService.getAllCartItems(cartItem);
	}
	
	
	@GetMapping("/getCart/{id}")
	public Optional<CartItem> getByCartId(@PathVariable("id") int cartId)
	{
		return cartService.getByCartId(cartId);
	}
	
	@PutMapping("/update/{id}")
	public CartItem updateCart(@PathVariable("id") int cartId, @RequestBody CartItem cartItem)
	{
		return cartService.updateCart(cartItem);
		
	}
	
	
	
	

}
