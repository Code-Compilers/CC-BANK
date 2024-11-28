package com.code_compilers.CC_BANK.model;

import jakarta.persistence.Entity;
<<<<<<< HEAD
import jakarta.persistence.Table;

@Entity
@Table(name = "savings_accounts")
public class SavingsAccount extends Account {

    private double interestRate;

    // Getters and Setters
=======

@Entity
public class SavingsAccount extends Account {
    private double interestRate;

>>>>>>> fbdddc27a17510f87eef5eba4bdf5daeb293f192
    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
<<<<<<< HEAD
=======

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "id=" + getId() +
                ", owner='" + getOwner() + '\'' +
                ", balance=" + getBalance() +
                ", interestRate=" + interestRate +
                '}';
    }
>>>>>>> fbdddc27a17510f87eef5eba4bdf5daeb293f192
}

