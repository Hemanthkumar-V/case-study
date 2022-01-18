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
	private String password;
	@Field
	private String uAddress;
	@Field
	private long mobile;
	@Field
	private String email;
	@Field
	private String role;
	

	
	public UserProfile()
	{
		
	}






	






	public UserProfile(int uId, String uName, String password, String uAddress, long mobile, String email,
			String role) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.password = password;
		this.uAddress = uAddress;
		this.mobile = mobile;
		this.email = email;
		this.role = role;
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













	public String getPassword() {
		return password;
	}













	public void setPassword(String password) {
		this.password = password;
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













	public String getRole() {
		return role;
	}













	public void setRole(String role) {
		this.role = role;
	}












}