package com.casestudy.userprofileservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.casestudy.userprofileservice.entity.UserProfile;
import com.casestudy.userprofileservice.repository.UserProfileRepository;
@Service
public class UserProfileService {
	
	@Autowired
	private UserProfileRepository userProfileRepository;
	
	

	public UserProfile saveUser(UserProfile userProfile) {
		
		return userProfileRepository.save(userProfile) ;
	}

	

	
//	public String  createUserProfile(UserProfile userProfile)
//	
//	{
//		String statusMsg="";
//		UserProfile user=new UserProfile(); 
//		try
//		{
//			user.setuId(user.getuId());
//			user.setuName(user.getuName());
//			user.setuAddress(user.getuAddress());
//			user.setMobile(user.getMobile());
//			user.setEmail(user.getEmail());
//		
//		     userProfileRepository.insert(user);
//		     statusMsg="Data  inserted succefully";
//	  }
//		catch(Exception e)
//		{
//			statusMsg="exception occured while inserting the data";
//		}
//		return statusMsg;
//	}
//	
	
	public List <UserProfile> getUserProfile(UserProfile userProfile)
	{
		return userProfileRepository.findAll();
	}
	
	
	
	public   Optional<UserProfile> getByIdUserProfile( int  uId)
	{
		return userProfileRepository.findById(uId);
	}
	
	
	public  void updateUserProfile()
	{
		
	}
	
	
	




	public void deleteUserProfile(int uId) {
		
		userProfileRepository.deleteById(uId);
	}




	public UserProfile findByMobileNumber(long mobile) {
		
		return userProfileRepository.findByMobile(mobile);
	}



	
}