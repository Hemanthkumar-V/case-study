package com.casestudy.walletservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallet")
public class WalletController {
	@GetMapping("/wal")
	public String getWallet()
	{
		return "iam wallet";
	}

}
