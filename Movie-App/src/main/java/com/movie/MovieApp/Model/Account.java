package com.movie.MovieApp.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customer_accounts")
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double balance;
    private int accountCreation;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")

    private Customer customer;


    public Account(){

    }

    public Account(double Accountbalance, int AccountCreation ){
        this.balance = Accountbalance;
        this.accountCreation = AccountCreation;
    }

    public int getAccountId(){
        return id;
    }

    public void setAccountId(int id){
        this.id = id;
    }

    public double getAccountBalance(){
        return balance;
    }

    public void setAccountBalance(double balance){
        this.balance = balance;
    }

    public int getAccountCreation(){
        return accountCreation;
    }

    public void setAccountCreation(int accountCreation) {
        this.accountCreation = accountCreation;
    }

    public Customer getCustomer(){
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

