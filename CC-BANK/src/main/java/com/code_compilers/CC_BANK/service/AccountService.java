package com.code_compilers.CC_BANK.service;

import com.code_compilers.CC_BANK.exception.InsufficientFundsException;
import com.code_compilers.CC_BANK.model.Account;
import com.code_compilers.CC_BANK.model.User;
import com.code_compilers.CC_BANK.respository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public String transferFunds(User user, double amount, String fromAccountType, String toAccountType) throws InsufficientFundsException, AccountNotFoundException {
        Account fromAccount = accountRepository.findByUserAndAccountType(user, fromAccountType)
                .orElseThrow(() -> new AccountNotFoundException(fromAccountType + " account not found"));

        Account toAccount = accountRepository.findByUserAndAccountType(user, toAccountType)
                .orElseThrow(() -> new AccountNotFoundException(toAccountType + " account not found"));

        fromAccount.withdraw(amount); // Withdraw from the source account
        toAccount.deposit(amount);    // Deposit into the target account

        accountRepository.save(fromAccount); // Save updated from account
        accountRepository.save(toAccount);   // Save updated to account

        return "Transfer successful!";
    }
}
