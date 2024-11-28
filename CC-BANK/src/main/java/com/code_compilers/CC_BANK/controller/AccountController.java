package com.code_compilers.CC_BANK.controller;

import com.code_compilers.CC_BANK.model.Account;
import com.code_compilers.CC_BANK.model.CheckingAccount;
import com.code_compilers.CC_BANK.model.SavingsAccount;
import com.code_compilers.CC_BANK.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/create")
    public String showCreateAccountForm() {
        return "create-account";
    }

    @PostMapping("/create")
    public String createAccount(
            @RequestParam String accountType,
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String email,
            @RequestParam String cellNumber,
            @RequestParam String pin,
            Model model) {

        Account account;
        if ("checking".equalsIgnoreCase(accountType)) {
            account = new CheckingAccount();
        } else if ("savings".equalsIgnoreCase(accountType)) {
            account = new SavingsAccount();
        } else {
            model.addAttribute("error", "Invalid account type");
            return "error";
        }

        account.setOwner(name + " " + surname);
        account.setEmail(email);
        account.setCellNumber(cellNumber);
        account.setPin(pin);
        accountService.createAccount(account);
        return "redirect:/";
    }

    @PostMapping("/access")
    public String accessAccount(
            @RequestParam String identifier,
            @RequestParam String pin,
            Model model) {

        Account account;
        try {
            account = accountService.accessAccount(identifier, pin);
            model.addAttribute("account", account); // Pass account data to the view
            return "account";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", "Invalid account number/email or PIN");
            return "index";
        }
    }

    @PostMapping("/{id}/delete")
    public String deleteAccount(@PathVariable Long id, @RequestParam String pin, Model model) {
        accountService.deleteAccount(id, pin);
        return "redirect:/";
    }

    @PostMapping("/{id}/deposit")
    public String deposit(@PathVariable Long id, @RequestParam double amount, @RequestParam String pin, Model model) {
        Account account = accountService.deposit(id, amount, pin);
        model.addAttribute("account", account);
        return "account";
    }


    @PostMapping("/{id}/withdraw")
    public String withdraw(@PathVariable Long id, @RequestParam double amount, @RequestParam String pin, Model model) {
        Account account = accountService.withdraw(id, amount, pin);
        model.addAttribute("account", account);
        return "account";
    }

    //samuel
    //Transfer
    //Check if the account numbers belong to the same user as the current user
    //If the same user it's a transfer between accounts
    /*
       If you determine that a transfer is between accounts, which means both accounts belong to the same user
       then use the two if statement blocks, to check if the account is a savings/cheque account

       Note: This assumes that you have a field in your Account entity to determine whether it's a savings or cheque account
     */
    @PostMapping("{id}/transfer")
    public String transfer(@RequestParam Long fromId, @RequestParam Long toId, @RequestParam double amount, @RequestParam String pin, Model model) {
        accountService.transfer(fromId, toId, amount, pin);
        Account fromAccount = accountService.getAccount(fromId, pin);
        Account toAccount = accountService.getAccount(toId, pin);
        model.addAttribute("fromAccount", fromAccount);
        model.addAttribute("toAccount", toAccount);

        return "transfer";
    }
}
