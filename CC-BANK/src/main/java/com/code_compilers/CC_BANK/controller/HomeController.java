package com.code_compilers.CC_BANK.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

        // Serve the signup.html page at the root URL
        @GetMapping("/")
        public String showSignUpPage() {
            return "Account";
        }
    }
