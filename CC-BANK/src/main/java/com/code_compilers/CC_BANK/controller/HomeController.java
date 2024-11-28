package com.code_compilers.CC_BANK.controller;

<<<<<<< HEAD
import org.springframework.stereotype.Controller;
=======
import com.code_compilers.CC_BANK.model.Account;
import com.code_compilers.CC_BANK.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
>>>>>>> fbdddc27a17510f87eef5eba4bdf5daeb293f192
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

<<<<<<< HEAD
        // Serve the signup.html page at the root URL
        @GetMapping("/")
        public String showSignUpPage() {
            return "Account";
        }
    }
=======
    @Autowired
    private AccountService accountService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("accounts");
        return "index";
    }
}


>>>>>>> fbdddc27a17510f87eef5eba4bdf5daeb293f192
