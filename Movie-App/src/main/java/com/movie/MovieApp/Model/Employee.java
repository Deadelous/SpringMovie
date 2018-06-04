package com.movie.MovieApp.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "employees")
public class Employee implements Serializable {
    @Id @GeneratedValue

    private Long id;
    private String name;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {

                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "employees")
    private List<Store> stores = new ArrayList<>();


    public Employee(){

    }

    public Employee(String name){
        this.name = name;
    }

    public Long getEmployeeId() {
        return id;
    }

    public void setEmployeeId(Long id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return name;
    }

    public void setEmployeeName(String name){
        this.name = name;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }
}
