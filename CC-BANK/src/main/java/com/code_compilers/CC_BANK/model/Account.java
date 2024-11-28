package com.code_compilers.CC_BANK.model;

import jakarta.persistence.*;

<<<<<<< HEAD

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String owner;
    private double balance;
    private String accountType;

=======
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String owner;
    private String email;
    private String cellNumber;
    private double balance;
    private String pin;
    private String accountType;



>>>>>>> fbdddc27a17510f87eef5eba4bdf5daeb293f192
    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

<<<<<<< HEAD
=======
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

>>>>>>> fbdddc27a17510f87eef5eba4bdf5daeb293f192
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

<<<<<<< HEAD
=======
    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

>>>>>>> fbdddc27a17510f87eef5eba4bdf5daeb293f192
    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}

