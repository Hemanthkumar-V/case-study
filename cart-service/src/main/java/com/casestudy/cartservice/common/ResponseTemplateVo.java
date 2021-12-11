package com.casestudy.cartservice.common;

import java.util.Optional;

import com.casestudy.cartservice.entity.CartItem;

public class ResponseTemplateVo {
 private Product product;
 private CartItem cartItem;
 
 public ResponseTemplateVo()
 {
	 
 }
public ResponseTemplateVo(Product product, CartItem cartItem) {
	super();
	this.product = product;
	this.cartItem = cartItem;
}
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}
public CartItem getCartitem() {
	return cartItem;
}
public void setCartitem(Optional<CartItem> cartItem2) {
	this.cartItem = cartItem;
}



}
