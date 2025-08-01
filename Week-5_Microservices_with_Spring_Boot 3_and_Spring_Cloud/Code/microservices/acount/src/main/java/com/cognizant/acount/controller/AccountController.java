package com.cognizant.acount.controller;

import com.cognizant.acount.model.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/accounts/{number}")
    public Account getAccountDetails(@PathVariable String number) {
        // Returning a dummy response as per the requirement
        return new Account("00987987973432", "savings", 234343);
    }
}