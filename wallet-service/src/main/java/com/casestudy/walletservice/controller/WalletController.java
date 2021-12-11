package com.casestudy.walletservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.walletservice.entity.Payment;
import com.casestudy.walletservice.service.WalletService;

@RestController
@RequestMapping("/wallet")
public class WalletController {
	
	@Autowired
	private WalletService walletService;
	
	
	@GetMapping("/wal")
	public String getWallet()
	{
		return "iam wallet";
	}
	@PostMapping("/dopayment")
	public Payment dopayment(@RequestBody Payment payment)
	{
		return walletService.doPayment(payment);
	}

}
