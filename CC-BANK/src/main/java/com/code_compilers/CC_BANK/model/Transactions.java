package com.code_compilers.CC_BANK.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "transactions")
public class Transactions {




        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int transactionId;

        @ManyToOne
        @JoinColumn(name = "account_id", nullable = false)
        private com.code_compilers.CC_BANK.model.Account account;

        @Column(name = "type", nullable = false)
        private String type;

        @Column(name = "amount", nullable = false)
        private BigDecimal amount;

        @Column(name = "timestamp", nullable = false, updatable = false)
        private Timestamp timestamp;

        // Getters and Setters
        // ...
    }


