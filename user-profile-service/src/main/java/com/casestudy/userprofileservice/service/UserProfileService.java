package com.casestudy.userprofileservice.service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.casestudy.userprofileservice.common.CartItem;
import com.casestudy.userprofileservice.common.Order;
import com.casestudy.userprofileservice.common.Product;
import com.casestudy.userprofileservice.common.ProductResponse;
import com.casestudy.userprofileservice.common.TransactionRequest;
import com.casestudy.userprofileservice.common.TransactionResponse;
import com.casestudy.userprofileservice.entity.UserProfile;
import com.casestudy.userprofileservice.repository.UserProfileRepository;

@Service
public class UserProfileService  {

	@Autowired
	private UserProfileRepository userProfileRepository;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private PasswordEncoder passEncoder;
	public static final String DEFAULT_ROLE="ROLE-USER";
	public static final String[] ADMIN_ACCESS= {"ROLE-USER","ROLE-ADMIN"};

	public String createUser(TransactionRequest request) {

		List<UserProfile> toUser = new ArrayList<UserProfile>();
		String msg = "";
		String password=request.getPassword();
		String encodePassword=passEncoder.encode(password);

		{
			UserProfile user = new UserProfile();
			user.setuId(request.getuId());
			user.setuName(request.getuName());
			user.setPassword(encodePassword);
			user.setuAddress(request.getuAddress());
			user.setMobile(request.getMobile());
			user.setEmail(request.getEmail());
			user.setRole(DEFAULT_ROLE);

			toUser.add(user);
		}
		try {

			userProfileRepository.insert(toUser);
			msg = "User Profile created succesfully";
		} catch (Exception e) {
			msg = " User Already Exist Login";
		}
		return msg;

	}
	
	public UserProfile getLoggedInUser(Principal principal) {
		return userProfileRepository.findByuName(principal.getName());
	}
	
	private List<String> getRolesByLoggedInUser(Principal principal)
	{
	String roles=getLoggedInUser(principal).getRole();
	List<String> assignRoles=Arrays.stream(roles.split(",")).collect(Collectors.toList());
	if(assignRoles.contains("ROLE-ADMIN"))
	{
	return Arrays.stream(ADMIN_ACCESS).collect(Collectors.toList());
	}
	return Collections.emptyList();
		
	}

	public List<UserProfile> getUserProfiles() {
		List<UserProfile> users = userProfileRepository.findAll();

		return users;
	}

	public UserProfile getByIdUserProfile(int uId) {
		List<UserProfile> to = userProfileRepository.findAll();
		UserProfile userProfile = null;
		for (UserProfile user : to) {
			if (user.getuId() == uId) {
				userProfile = user;
			}
		}
		return userProfile;

	}

	public String updateUserProfile(TransactionRequest request) {
		String msg = "";
		UserProfile user = new UserProfile();
		user.setuId(request.getuId());
		user.setuName(request.getuName());
		user.setPassword(request.getPassword());
		user.setuAddress(request.getuAddress());
		user.setMobile(request.getMobile());
		user.setEmail(request.getEmail());

		try {
			userProfileRepository.save(user);
			msg = "product updated succefully";
		} catch (Exception e) {
			msg = "exception occured while updating the product";
		}
		return msg;
	}

	public boolean deleteUserById(int uId) {
		boolean success = false;
		userProfileRepository.deleteById(uId);
		success = true;
		return success;
	}

//get user by username
	public UserProfile getByuName(String uName) {

		return userProfileRepository.findByuName(uName);
	}


	public List<UserProfile> findBymobile(long mobile) {
		List<UserProfile> to = new ArrayList<UserProfile>();
		UserProfile users = new UserProfile();

		List<UserProfile> userBymobile = userProfileRepository.findBymobile(mobile);
		return userBymobile;

	}

	// User can Able to fetch the data from product microservices

	// getting products from product microservice All the products

	public TransactionResponse getAllProducts() {
		Product product = new Product();
		ProductResponse response = new ProductResponse();
		ProductResponse productResponse = restTemplate.getForObject("http://localhost:8081/product/getProducts",
				ProductResponse.class);

		return new TransactionResponse(productResponse.getProducts());
	}

	// getting products from product microservice based on product id

	public Product getProductById(int id) {
		Product product = new Product();

		ProductResponse response = new ProductResponse();
		ProductResponse productResponse = restTemplate.getForObject("http://localhost:8081/product/getProduct/" + id,
				ProductResponse.class);

		return productResponse.getProduct();
	}

	// getting products from product microservice based on product category

	public TransactionResponse getProductByCategory(String productCategory) {
		Product product = new Product();
		ProductResponse response = new ProductResponse();
		ProductResponse productResponse = restTemplate
				.getForObject("http://localhost:8081/product/getproduct/" + productCategory, ProductResponse.class);

		return new TransactionResponse(productResponse.getProducts());
	}

//	

	/*
	 * .........................................Order related
	 * operations..................................
	 */

	public Order placeOrder(Order order) {

		UserProfile user1 = (UserProfile) getByIdUserProfile(order.getUserId());

		Product product1 = getProductById(order.getProductId());

		Product product = new Product();
		// UserProfile user = new UserProfile();
		order.setOrderId(order.getOrderId());
		order.setUserId(user1.getuId());
		order.setUserame(user1.getuName());
		order.setProductId(product1.getProductId());
		order.setProductName(product1.getProductName());
		order.setProductPrice(product1.getPrice());
		order.setQty(order.getQty());
		order.setOrderPrice(product1.getPrice() * order.getQty());
		order.setShippingAddress(user1.getuAddress());
		order.setPaymentType(order.getPaymentType());

		Order orderResponce = restTemplate.postForObject("http://localhost:8086/order/saveOrder/", order, Order.class);
		return order;
	}

	public Order[] getOrderByID(int id) {
		Order[] orderresponse = restTemplate.getForObject("http://localhost:8086/order/getOrder/" + id, Order[].class);
		return orderresponse;
	}

	/*
	 * ............................................... Cart related
	 * operations...............................
	 */
	public CartItem addToCart(CartItem cartItem) {

		UserProfile user1 = (UserProfile) getByIdUserProfile(cartItem.getUserId());

		Product product1 = getProductById(cartItem.getProductId());
		cartItem.setCartId(cartItem.getCartId());
		cartItem.setUserId(user1.getuId());
		cartItem.setProductId(product1.getProductId());
		cartItem.setProductName(product1.getProductName());
		cartItem.setProductPrice(product1.getPrice());
		cartItem.setProductQty(cartItem.getProductQty());
		cartItem.setTotalcostofeachproduct(product1.getPrice() * cartItem.getProductQty());

		CartItem cartResponse = restTemplate.postForObject("http://localhost:8084/cart/addToCart/", cartItem,
				CartItem.class);

		return cartResponse;
	}

	public List<CartItem> getAllItemsFromCart() {
		List<CartItem> getAllItemsFromCart = (List<CartItem>) restTemplate
				.getForObject("http://localhost:8084/cart/getCart/", CartItem.class);
		return getAllItemsFromCart;
	}

	public CartItem getCartItemsById(int id) {
		CartItem cartResponseById = restTemplate.getForObject("http://localhost:8084/cart/getCart/" + id,
				CartItem.class);
		return cartResponseById;
	}

	public String deleteItemFromCart(int id) {
		restTemplate.delete("http://localhost:8084/cart/deleteCartItem/" + id, CartItem.class);
		return "Item deleted from cart succeefully";
	}

	public String giveAccessToUser(int uId, String role, Principal principal) {
		UserProfile userProfile=userProfileRepository.findById(uId).get();
		List<String>activeRoles=getRolesByLoggedInUser(principal);
		String newRole;
		if(activeRoles.contains(role))
		{
			newRole=userProfile.getRole()+","+role;
			userProfile.setRole(newRole);
		}
		userProfileRepository.save(userProfile);
		
		return "Hi"+userProfile.getuName()+"new role assigned to you by "+principal.getName();
	}


	}

	
	
	

