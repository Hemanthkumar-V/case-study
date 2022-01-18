package com.casestudy.userprofileservice.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.casestudy.userprofileservice.entity.UserProfile;


@Service
public class UserServices implements UserDetails{
	
private UserProfile userProfile;

public UserServices() {
	super();
	this.userProfile = userProfile;
}

//	private String username;
//	private String password;
//	private String userAddress;
//	private long mobile;
//	private String email;
//	private List<GrantedAuthority>authorities;
//	public UserServices()
//	{
//		
//	}
//	
//
//	public UserServices(UserProfile userProfile) {
//		this.username=userProfile.getuName();
//		this.password=userProfile.getPassword();
////		this.userAddress=userProfile.getuAddress();
////		this.mobile=userProfile.getMobile();
////		this.email=userProfile.getEmail();
//		this.authorities=Arrays.stream(userProfile.getRole().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
//		
//	}

	public UserProfile getUserProfile() {
	return userProfile;
}

public void setUserProfile(UserProfile userProfile) {
	this.userProfile = userProfile;
}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Arrays.stream(userProfile.getRole().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return userProfile.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userProfile.getuName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}

