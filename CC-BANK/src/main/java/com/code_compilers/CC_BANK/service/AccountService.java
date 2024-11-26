package com.code_compilers.CC_BANK.service;


import com.code_compilers.CC_BANK.respository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Transfer amount must be greater than zero");
        }

        // Fetch the accounts
        Optional<Account> fromAccountOpt = accountRepository.findByAccountNumber(fromAccountNumber);
        Optional<Account> toAccountOpt = accountRepository.findByAccountNumber(toAccountNumber);

        if (fromAccountOpt.isEmpty() || toAccountOpt.isEmpty()) {
            throw new IllegalArgumentException("Invalid account number(s)");
        }

        Account fromAccount = fromAccountOpt.get();
        Account toAccount = toAccountOpt.get();

        // Validate sufficient balance
        if (fromAccount.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient funds in account: " + fromAccountNumber);
        }

        // Perform the transfer
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        // Save updated accounts
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        // Record transactions
        Transaction fromTransaction = new Transaction();
        fromTransaction.setAccount(fromAccount);
        fromTransaction.setType("transfer");
        fromTransaction.setAmount(-amount);
        transactionRepository.save(fromTransaction);

        Transaction toTransaction = new Transaction();
        toTransaction.setAccount(toAccount);
        toTransaction.setType("transfer");
        toTransaction.setAmount(amount);
        transactionRepository.save(toTransaction);
    }
}
