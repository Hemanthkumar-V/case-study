package com.casestudy.categoryservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("admin")
public class AdminEntity {
	@Id
    private	int adminId;
	private int adminName;
	public AdminEntity()
	{
		
	}
	public AdminEntity(int adminId, int adminName) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public int getAdminName() {
		return adminName;
	}
	public void setAdminName(int adminName) {
		this.adminName = adminName;
	}
	

}
