package com.code_compilers.CC_BANK.service;

import com.code_compilers.CC_BANK.model.CheckingAccount;
import com.code_compilers.CC_BANK.model.SavingsAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferService {

    @Autowired
    private AccountRepository accountRepository;

    public void transfer(String fromAccountId, String toAccountId, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Transfer amount must be greater than zero");
        }

        // Fetch accounts from repository
        SavingsAccount savingsAccount = accountRepository.findSavingsAccountById(fromAccountId);
        CheckingAccount checkingAccount = accountRepository.findCheckingAccountById(toAccountId);

        // Validate accounts and balances
        if (savingsAccount == null) {
            throw new IllegalArgumentException("Savings account not found: " + fromAccountId);
        }
        if (checkingAccount == null) {
            throw new IllegalArgumentException("Checking account not found: " + toAccountId);
        }
        if (savingsAccount.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient balance in savings account");
        }

        // Perform the transfer
        savingsAccount.setBalance(savingsAccount.getBalance() - amount);
        checkingAccount.setBalance(checkingAccount.getBalance() + amount);

        // Save updated accounts back to the repository
        accountRepository.save(savingsAccount);
        accountRepository.save(checkingAccount);
    }
}
