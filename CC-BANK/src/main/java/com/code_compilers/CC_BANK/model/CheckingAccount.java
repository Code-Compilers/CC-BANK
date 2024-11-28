package com.code_compilers.CC_BANK.model;

<<<<<<< HEAD

=======
>>>>>>> fbdddc27a17510f87eef5eba4bdf5daeb293f192
import jakarta.persistence.Entity;

@Entity
public class CheckingAccount extends Account {
<<<<<<< HEAD

    private double overdraftLimit;

    // Getters and Setters
=======
    private double overdraftLimit;

>>>>>>> fbdddc27a17510f87eef5eba4bdf5daeb293f192
    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }
<<<<<<< HEAD
=======

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "id=" + getId() +
                ", owner='" + getOwner() + '\'' +
                ", balance=" + getBalance() +
                ", overdraftLimit=" + overdraftLimit +
                '}';
    }
>>>>>>> fbdddc27a17510f87eef5eba4bdf5daeb293f192
}

