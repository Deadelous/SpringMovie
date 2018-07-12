package com.movie.movie.Model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="Authors")
public class Author extends Movie implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    public Author(){

    }

    public Author(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
