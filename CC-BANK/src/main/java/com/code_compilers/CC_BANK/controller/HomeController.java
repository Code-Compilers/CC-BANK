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

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("accounts", accountService.getAllAccounts());
        return "index";
    }

    @GetMapping("/account")
    public String account(Model model) {
        model.addAttribute("account");
        return "account";
    }

}



