package com.casestudy.categoryservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.categoryservice.entity.AdminEntity;

public interface AdminRepository extends MongoRepository<AdminEntity, Integer> {
	public AdminEntity getAdminByName();

}
