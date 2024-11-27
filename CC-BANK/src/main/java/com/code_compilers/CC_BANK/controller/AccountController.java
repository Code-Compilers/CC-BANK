package com.code_compilers.CC_BANK.controller;

import com.code_compilers.CC_BANK.exception.AccountNotFoundException;
import com.code_compilers.CC_BANK.exception.InsufficientFundsException;
import com.code_compilers.CC_BANK.exception.UserNotFoundException;
import com.code_compilers.CC_BANK.model.User;
import com.code_compilers.CC_BANK.respository.UserRepository;
import com.code_compilers.CC_BANK.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;


@Controller
public class AccountController {

        @Autowired
        private AccountService accountService;

        @PostMapping("/transfer")
        public String transfer(@RequestParam double amount,
                               @RequestParam String fromAccountType,
                               @RequestParam String toAccountType,
                               Principal principal) {
            User user = getUserFromPrincipal(principal); // Assuming a method that retrieves the user from the authenticated principal

            try {
                String result = accountService.transferFunds(user, amount, fromAccountType, toAccountType);
                return "redirect:/dashboard?success=" + result;
            } catch (AccountNotFoundException | InsufficientFundsException e) {
                return "redirect:/dashboard?error=" + e.getMessage();
            }
        }

        private User getUserFromPrincipal(Principal principal) {
            // Get the user based on the authenticated principal

            return UserRepository.findByUsername(principal.getName()).orElseThrow(() -> new UserNotFoundException("User not found"));
        }
    }


