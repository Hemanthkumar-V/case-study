package com.casestudy.cartservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@CrossOrigin(origins = "*")
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
	
	@PostMapping("/addToCart")
	public CartItem addToCart(@RequestBody CartItem cartItem)
	{
		return cartService.addToCart(cartItem);
		
	}
	
	@GetMapping("/getCart")
	public List<CartItem> getAllCartItems()
	{
		return cartService.getAllCartItems();
	}
	
	
	@GetMapping("/getCart/{id}")
	public CartItem getByCartId(@PathVariable("id") int cartId)
	{
		return cartService.getByCartId(cartId);
	}
	
	@PutMapping("/updateCart/{id}")
	public CartItem updateCart(@PathVariable("id") int cartId, @RequestBody CartItem cartItem)
	{
		cartItem.setCartId(cartItem.getCartId());
		return cartService.updateCart(cartItem);
		
	}
	
	@DeleteMapping("/deleteCartItem/{id}")
	public String deleteCartItem(@PathVariable("id") int id) {
		return cartService.deleteCartItem(id);
	}
	
	

}
