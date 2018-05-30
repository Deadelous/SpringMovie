package com.movie.MovieApp.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "customers")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String adress;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "customer")

    public Account account;

    public Customer(){

    }

    public Customer(String customerName, String customerAdress){
        this.name = customerName;
        this.adress = customerAdress;
    }

    public int getCustomerId(){ return id; }

    public void setCustomerId(int id){
        this.id = id;
    }

    public String getCustomerName() {
        return name;
    }

    public void setCustomerName(String name){
        this.name = name;
    }

    public String getCustomerAdress() {
        return adress;
    }

    public void setCustomerAdress(String adress){
        this.adress = adress;
    }

    public Account getAccount(){
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
