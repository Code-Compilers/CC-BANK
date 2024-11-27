package com.code_compilers.CC_BANK.controller;

import com.code_compilers.CC_BANK.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/transfer")
    public ResponseEntity<String> transferFunds(
            @RequestParam Long fromAccountId,
            @RequestParam Long toAccountId,
            @RequestParam double amount) {

        accountService.transferFunds(fromAccountId, toAccountId, amount);
        return ResponseEntity.ok("Transfer successful");
    }
}
