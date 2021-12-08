package com.casestudy.userprofileservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.userprofileservice.entity.UserProfile;

@Repository
public interface UserProfileRepository extends MongoRepository<UserProfile, Integer> {

	UserProfile findByMobile(long mobile);

}
