package com.movie.movie.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@NamedQueries({
        @NamedQuery(name = "Account.getAll", query="Select a from Account a"),
        @NamedQuery(name = "Account.findUsername",
                    query="SELECT a FROM Account a where a.username = :username"),
        @NamedQuery(name = "Account.findByID", query="Select a FROM Account a where a.id = :id")
})
@Table(name="accounts")

public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double balance;
    private int accountCreation;
    private String username;
    private String password;
    private boolean admin;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "account")
    private Customer customer;


    public Account() {

    }

    public Account(String username, String password, boolean admin) {
        this.username = username;
        this.password = password;
        this.admin = admin;
    }

    public Account(double Accountbalance, int AccountCreation, String username, String password, boolean admin) {
        this.balance = Accountbalance;
        this.accountCreation = AccountCreation;
        this.username = username;
        this.password = password;
        this.admin = admin;
    }

    public Account(double Accountbalance, int AccountCreation) {
        this.balance = Accountbalance;
        this.accountCreation = AccountCreation;
    }

    public Long getAccountId() {
        return id;
    }

    public void setAccountId(Long id) {
        this.id = id;
    }

    public double getAccountBalance() {
        return balance;
    }

    public void setAccountBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountCreation() {
        return accountCreation;
    }

    public void setAccountCreation(int accountCreation) {
        this.accountCreation = accountCreation;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}

