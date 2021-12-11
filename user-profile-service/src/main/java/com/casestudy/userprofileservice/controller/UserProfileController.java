package com.casestudy.userprofileservice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.casestudy.userprofileservice.common.TransactionResponse;
import com.casestudy.userprofileservice.entity.UserProfile;
import com.casestudy.userprofileservice.service.UserProfileService;

@RestController
@RequestMapping("/user")
public class UserProfileController {
	
	@Autowired
	private UserProfileService userProfileService;
	
	@RequestMapping("/hemanth")
	public String getUser()
	{
		return "hello hemanth";
	}
	@RequestMapping("/getAllProducts")
	public TransactionResponse getAllProducts()
	{
		return userProfileService.getAllProducts();
		
	}
	
//	public class ConsumeWebService {
//		   @Autowired
//		  private RestTemplate restTemplate;
//
//		   @RequestMapping(value = "/getAll")
//		   public String getProductList() {
//		      HttpHeaders headers = new HttpHeaders();
//		      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//		      HttpEntity <String> entity = new HttpEntity<String>(headers);
//		      
//		      return restTemplate.exchange("http://localhost:8081/product/getProducts", HttpMethod.GET, entity, String.class).getBody();
//		   }
//		}
	
//	@PostMapping("/create")
//	public  String createUserProfile(@RequestBody UserProfile userProfile)
//	{
//		String responseMsg="";
//		if(userProfile!=null)
//			try
//		{
//			 responseMsg=createUserProfile(userProfile);
//	}
//		catch(Exception e){
//			 responseMsg="userProfiloe is empty";
//			
//		}
//		return responseMsg;
//	}
//	
	@GetMapping("/getUser")
	public  List<UserProfile> getUserProfile(UserProfile userProfile  )
	{
		return userProfileService.getUserProfile(userProfile );
	}
	
	
	@GetMapping("/{id}")
	public  Optional<UserProfile> getByIdUserProfile(@PathVariable("id") int  uId)
	{
		return userProfileService.getByIdUserProfile(uId);	
	}
	
	@PutMapping("/update")
	public  void updateUserProfile()
	{
		userProfileService.updateUserProfile();
	}
	
	@DeleteMapping("/delete/{id}")
	public  void deleteUserProfileById(@PathVariable("id")int uId)
	{
		userProfileService.deleteUserProfile(uId);
	}
	
	@PostMapping("/save")
	public UserProfile saveUser( @RequestBody UserProfile userProfile)
	{
		return userProfileService.saveUser(userProfile);
		
	}
	
	@GetMapping("/mobile/{mobile}")
	public UserProfile findByMobileNumber(@PathVariable long mobile)
	{
		return userProfileService.findByMobileNumber(mobile);
	}

}
