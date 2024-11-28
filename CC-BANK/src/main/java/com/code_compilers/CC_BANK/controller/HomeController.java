package com.code_compilers.CC_BANK.controller;


import org.springframework.stereotype.Controller;
import com.code_compilers.CC_BANK.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
        @Autowired
        private AccountService accountService;
        // Serve the signup.html page at the root URL
        @GetMapping("/")
        public String showSignUpPage() {
            return "Account";
        }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("accounts");
        return "index";
    }
    }

