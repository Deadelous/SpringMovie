package com.movie.movie.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "customers")
public class Customer implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String adress;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    public Customer(){

    }

    public Customer(String customerName, String customerAdress){
        this.name = customerName;
        this.adress = customerAdress;
    }

    public Long getCustomerId(){ return id; }

    public void setCustomerId(Long id){
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

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", account=" + account +
                '}';
    }
}
