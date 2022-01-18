package com.casestudy.userprofileservice.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.userprofileservice.common.CartItem;
import com.casestudy.userprofileservice.common.Order;
import com.casestudy.userprofileservice.common.Product;
import com.casestudy.userprofileservice.common.TransactionRequest;
import com.casestudy.userprofileservice.common.TransactionResponse;
import com.casestudy.userprofileservice.entity.UserProfile;
import com.casestudy.userprofileservice.service.UserProfileService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserProfileController {

	// USER RELATED OPERATIONS

	@Autowired
	private UserProfileService userProfileService;
	
//	@Autowired
//	private AuthenticationManager authenticationManager;

	@RequestMapping("/hemanth")
	public String getUser() {
		return "hello hemanth";
	}
  /*...........................User Related Operations....................................*/
	@PostMapping("/saveUser")
	public String createUser(@RequestBody TransactionRequest request) {

//		{
//			TransactionResponse response = new TransactionResponse();
//
//			try {
//				String msg = userProfileService.createUser(request);
//
//				response.setStatusCode(200);
//				response.setStatusMassage(msg);
//				response.setAppName("UserProfile-Service");
//				response.setPort(8082);
//			} catch (Exception e) {
//				String msg = userProfileService.createUser(request);
//
//				response.setStatusCode(400);
//				response.setStatusMassage(msg);
//				response.setAppName("UserProfile-Service");
//				response.setPort(8082);
//			}
//			return response;
//		}
		return userProfileService.createUser(request);

	}
	
//	private UserProfile  getLoggedInUser(Principal principal)
//	{
//		return userProfileService.getLoggedInUser(principal);
//	}
	
	
	@GetMapping("/giveAccess/{uId}/{role}")
	@PreAuthorize("hasAuthority('ROLE-ADMIN')")
	
		public String giveAccessToUser(@PathVariable("uId") int uId,@PathVariable("role") String  role, Principal principal)
		{
			return userProfileService.giveAccessToUser(uId,role,principal);
			
		}

	
	

	@GetMapping("/getUsers")
	@PreAuthorize("hasAuthority('ROLE-USER')")
	public TransactionResponse getUserProfile() {
		TransactionResponse response = new TransactionResponse();
		try {
			List<UserProfile> allUsers = userProfileService.getUserProfiles();

			response.setStatusCode(200);
			response.setStatusMassage("Successfully fetched the data");
			response.setAppName("UserProfile-Service");
			response.setPort(8082);
			response.setUsers(allUsers);

		} catch (Exception e) {
			response.setStatusCode(400);
			response.setStatusMassage("Exception occured while fetching the product");
			response.setAppName("Product-Service");
			response.setPort(8082);

		}
		return response;
	}

	@GetMapping("/{id}")
	public TransactionResponse getByIdUserProfile(@PathVariable("id") int uId) {
		TransactionResponse response = new TransactionResponse();

		try {

			List<UserProfile> userbyId = (List<UserProfile>) userProfileService.getByIdUserProfile(uId);

			response.setStatusCode(200);
			response.setStatusMassage("Successfully fetched the data");
			response.setAppName("UserProfile-Service");
			response.setPort(8082);
			response.setUsers(userbyId);
		} catch (Exception e) {
			response.setStatusCode(400);
			response.setStatusMassage("Exception occured while fetching the user");
			response.setAppName("UserProfile-Service");
			response.setPort(8082);

		}
		return response;

	}
	
	@GetMapping("/getByUserName/{uName}")
	public UserProfile getByuName(@PathVariable("uName") String uName)
	{
	//String uName=userProfile.getuName();
		return userProfileService.getByuName(uName);
		
	}

	@DeleteMapping("/delete/{id}")
	public TransactionResponse deleteUserProfileById(@PathVariable("id") int uId) {

		String msg = "";
		TransactionResponse response = new TransactionResponse();
		boolean success = false;
		success = userProfileService.deleteUserById(uId);
		if (success) {
			msg = "User deleted successfully";

			response.setStatusCode(200);
			response.setStatusMassage(msg);
			response.setAppName("UserProfile-Service");
			response.setPort(8082);

		} else {
			response.setStatusCode(400);
			response.setStatusMassage("Exception occured while deleting the user");
			response.setAppName("UserProfile-Service");
			response.setPort(8082);

		}
		return response;

	}

	@PutMapping("/updateUser/{id}")
	public TransactionResponse updateUserProfile(@PathVariable("id") int id, @RequestBody TransactionRequest request) {
		request.setuId(id);
		String msg = userProfileService.updateUserProfile(request);
		TransactionResponse response = new TransactionResponse();

		try {
			response.setStatusCode(200);
			response.setStatusMassage(msg);
			response.setAppName("UserProfile-Service");
			response.setPort(8082);

		} catch (Exception e) {
			response.setStatusCode(400);
			response.setStatusMassage("Updation Fail");
			response.setAppName("Product-Service");
			response.setPort(8082);

		}
		return response;

	}
	


	@GetMapping("/mobile/{mobile}")
	public TransactionResponse findBymobile(@PathVariable("mobile") long mobile) {
		TransactionResponse response = new TransactionResponse();

	try {

			List<UserProfile> userbymobile = userProfileService.findBymobile(mobile);

			response.setStatusCode(200);
			response.setStatusMassage("Successfully fetched the data");
		response.setAppName("UserProfile-Service");
			response.setPort(8082);
			response.setUsers(userbymobile);
		} catch (Exception e) {
		response.setStatusCode(400);
			response.setStatusMassage("Exception occured while fetching the user");
			response.setAppName("UserProfile-Service");
			response.setPort(8082);

	}
		return response;

	}
	
	
	/*......................................Product related operations............................................*/
	
	// User can Search the products by Id by category and can get All product details
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/getAllProducts")
	public TransactionResponse getAllProducts() {
		return userProfileService.getAllProducts();

	}

	@GetMapping("/productById/{id}")
	public Product getProductById(@PathVariable("id") int id) {
		return userProfileService.getProductById(id);

	}

	@GetMapping("/productByCategory/{productCategory}")
	public TransactionResponse getProductByCategory(@PathVariable("productCategory") String productCategory) {
		return userProfileService.getProductByCategory(productCategory);

	}
	
	
	
	/*....................................Order related oprations ............................*/
	
	@PostMapping("/placeOrder")
public Order placeOrder(@RequestBody Order order)
	
	{
	return userProfileService.placeOrder(order);
	}
	
	@GetMapping("/getOrderById/{id}")
	public Order[] getOrderByID(@PathVariable("id") int id)
	{
		return  userProfileService.getOrderByID(id);
	}
	
	
	
	
	
	/*..................................... Cart related Operation .................................*/
	@PostMapping("/addToCart")
	public CartItem addToCart(@RequestBody CartItem cartItem )
	{
		return userProfileService.addToCart(cartItem);
	}
	
	@GetMapping("/getAllItemsFromCart")
	public List<CartItem> getAllItemsFromCart()
	{
		return userProfileService.getAllItemsFromCart();
	}
	
	@GetMapping("/getCartItemsById/{id}")
	public CartItem getCartItemsById(@PathVariable("id") int id) {
		return userProfileService.getCartItemsById(id);
	}
	
	@DeleteMapping("/deleteItemFromCart/{id}")
	public String deleteItemFromCart(@PathVariable("id") int id)
	{
		return userProfileService.deleteItemFromCart(id);
	}
	
	



}
