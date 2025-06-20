package com.example.cashcard;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CashCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;

    // No-args constructor for JPA
    public CashCard() {
    }

    // Constructor to create CashCard instances
    public CashCard(Long id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public Long id(){
        return this.getId();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public Double amount(){
        return this.getAmount();
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}