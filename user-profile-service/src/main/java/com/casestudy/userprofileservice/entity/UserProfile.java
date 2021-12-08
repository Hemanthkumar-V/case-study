package com.casestudy.userprofileservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("User")
public class UserProfile {
	@Id
	private  int uId;
	@Field
	private String uName;
	@Field
	private String uAddress;
	@Field
	private long mobile;
	@Field
	private String email;
	
	public UserProfile()
	{
		
	}
	
	
	public UserProfile(int uId, String uName, String uAddress, long mobile, String email) {
		
		this.uId = uId;
		this.uName = uName;
		this.uAddress = uAddress;
		this.mobile = mobile;
		this.email = email;
	}


	public int getuId() {
		return uId;
	}


	public void setuId(int uId) {
		this.uId = uId;
	}


	public String getuName() {
		return uName;
	}


	public void setuName(String uName) {
		this.uName = uName;
	}


	public String getuAddress() {
		return uAddress;
	}


	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}


	public long getMobile() {
		return mobile;
	}


	public void setMobile(long mobile) {
		this.mobile = mobile;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	} 
	
	

}
