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

<<<<<<< HEAD
    public void transferFunds(Long fromAccountId, Long toAccountId, double amount) {
        // Fetch source and destination accounts
        Account fromAccount = accountRepository.findById(fromAccountId)
                .orElseThrow(() -> new AccountNotFoundException("Source account not found"));
        Account toAccount = accountRepository.findById(toAccountId)
                .orElseThrow(() -> new AccountNotFoundException("Destination account not found"));

        // Ensure accounts are not the same
        if (fromAccountId.equals(toAccountId)) {
            throw new IllegalArgumentException("Cannot transfer to the same account");
        }

        // Validate sufficient funds in the source account
        if (fromAccount.getBalance() < amount) {
            throw new InsufficientFundsException("Insufficient balance in source account");
        }

        // Update balances
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        // Save updated accounts
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
    }

}
=======
    @Transactional

    public void deleteAccount(Long id, String pin) {

        Account account = getAccount(id, pin);

        accountRepository.delete(account);

    }

    @Transactional
    public Account deposit(Long id, double amount, String pin) {
        Account account = getAccount(id, pin);
        account.setBalance(account.getBalance() + amount);
        return accountRepository.save(account);
    }

}

>>>>>>> 14e2f0644551e9149b62773fefc9fd1f7d38e722
