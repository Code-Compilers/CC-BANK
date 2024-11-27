package com.code_compilers.CC_BANK.model;


import jakarta.persistence.Entity;

@Entity
public class CheckingAccount extends Account {

    private double overdraftLimit;

    // Getters and Setters
    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }
}
