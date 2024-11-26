package com.code_compilers.CC_BANK.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

        // Serve the signup.html page at the root URL
        @GetMapping("/")
        public String showSignUpPage() {
            return "signup.html";
        }

        // Serve the login page
        @GetMapping("/login")
        public String showLoginPage() {
            return "login.html";
        }

        // Serve the dashboard page (redirect to login if not authenticated)
        @GetMapping("/dashboard")
        public String showDashboardPage() {
            // If you want authentication check, you can add it here
            return "dashboard.html";
        }
    }
