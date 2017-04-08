package com.nielsen.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	@RequestMapping(value = "svc/v1/public/accounts/{accountNumber}")
	public String getPublicAccount(@PathVariable final int accountNumber) {
		return "Public Account Lined To: " + accountNumber;
	}

	@RequestMapping(value = "svc/v1/private/accounts/{accountNumber}")
	public String getPrivateAccount(@PathVariable final int accountNumber) {
		return "Private Account Lined To: " + accountNumber;
	}

	@RequestMapping(value = "svc/v1/private/admin/accounts/{accountNumber}")
	public String getPrivateAdminAccount(@PathVariable final int accountNumber) {
		return "Private Admin Account Lined To: " + accountNumber;
	}
}
