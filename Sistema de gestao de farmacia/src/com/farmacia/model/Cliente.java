package com.farmacia.model;

import java.io.Serializable;

public class Cliente implements Serializable {
    private int id;
    private String name;
    private double balance;

    public Cliente(int id, String name) {
        this.id = id;
        this.name = name;
        this.balance = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return " ID: "+id+
                "\n nome: "+name+
                "\n balance: "+balance;
    }
}
