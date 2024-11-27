package com.code_compilers.CC_BANK.model;

import com.code_compilers.CC_BANK.exception.InsufficientFundsException;

public abstract class Account {
    private Long id;
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (balance < amount) {
            throw new InsufficientFundsException("Insufficient funds.");
        }
        this.balance -= amount;
    }
}
