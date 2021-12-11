package com.casestudy.walletservice.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.walletservice.entity.Payment;
import com.casestudy.walletservice.repository.WalletRepository;
@Service
public class WalletService {
	@Autowired WalletRepository walletRepository;

	
	public Payment doPayment(Payment payment)
	{
		payment.setPaymentStatus(paymentProcessing());
		payment.setTransactionId(UUID.randomUUID().toString());
		return walletRepository.save(payment);
	}
	
	public String paymentProcessing()
	{
	return new Random().nextBoolean()?"success":"fail";
	}
}
