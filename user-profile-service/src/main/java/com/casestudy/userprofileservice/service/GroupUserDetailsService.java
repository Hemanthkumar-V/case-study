package com.casestudy.userprofileservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.casestudy.userprofileservice.entity.UserProfile;
import com.casestudy.userprofileservice.repository.UserProfileRepository;
@Service
public class GroupUserDetailsService implements UserDetailsService {
	@Autowired
	private UserProfileRepository userProfileRepostory;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserProfile user=userProfileRepostory.findByuName(username);
		UserServices userDetails=null;
		if(user!=null)
		{
			userDetails=new UserServices();
			userDetails.setUserProfile(user);
		}  
		else
		{
			throw new UsernameNotFoundException("user not exist with the name"+username);
		}
		return userDetails;
		 
	}

}
