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
@Table(name = "stores")
public class Store implements Serializable {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private String adress;
    private int movieamount;

    @OneToMany(
            mappedBy = "store",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Movie> movies = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "store_employees",
            joinColumns = { @JoinColumn(name = "store_id") },
            inverseJoinColumns = { @JoinColumn(name = "employee_id") })
    private List<Employee> employees = new ArrayList<>();

    public Store(){

    }

    public Store(String storeName,String storeAdress, int storeMovieAmount){
        this.name = storeName;
        this.adress = storeAdress;
        this.movieamount = storeMovieAmount;
    }

    public Long getStoreId(){
        return id;
    }

    public void setStoreId(Long id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getMovieamount() {
        return movieamount;
    }

    public void setMovieamount(int movieamount) {
        this.movieamount = movieamount;
    }

    public List<Movie> getMovies(){
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
