package com.code_compilers.CC_BANK.service;

import com.code_compilers.CC_BANK.exception.AccountNotFoundException;
import com.code_compilers.CC_BANK.exception.InsufficientFundsException;
import com.code_compilers.CC_BANK.model.Account;
import com.code_compilers.CC_BANK.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Transactional
    public Account accessAccount(String identifier, String pin) {
        Account account = accountRepository.findByEmail(identifier)
                .or(() -> accountRepository.findById(Long.parseLong(identifier)))
                .orElseThrow(() -> new AccountNotFoundException("Account not found"));

        if (!account.getPin().equals(pin)) {
            throw new IllegalArgumentException("Invalid PIN");
        }
        return account;
    }

    @Transactional
    public Account getAccount(Long id, String pin) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account not found"));
        if (!account.getPin().equals(pin)) {
            throw new IllegalArgumentException("Invalid PIN");
        }
        return account;
    }

    @Transactional
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Transactional
    public Account deposit(Long id, double amount, String pin) {
        Account account = getAccount(id, pin);
        account.setBalance(account.getBalance() + amount);
        return accountRepository.save(account);
    }

}

