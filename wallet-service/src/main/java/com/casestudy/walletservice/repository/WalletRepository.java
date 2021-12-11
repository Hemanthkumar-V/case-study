package com.casestudy.walletservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.walletservice.entity.Payment;


@Repository
public interface WalletRepository extends MongoRepository<Payment, Integer> {


}
