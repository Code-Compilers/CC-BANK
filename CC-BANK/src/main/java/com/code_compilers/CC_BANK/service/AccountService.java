package com.code_compilers.CC_BANK.service;

import com.code_compilers.CC_BANK.exception.AccountNotFoundException;
import com.code_compilers.CC_BANK.exception.InsufficientFundsException;
import com.code_compilers.CC_BANK.model.Account;
import com.code_compilers.CC_BANK.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

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
