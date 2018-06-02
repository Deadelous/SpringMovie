package com.movie.MovieApp.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="movies")
public abstract class Movie implements Serializable {
    @Id @GeneratedValue

    private Long id;
    @NotNull
    private String title;
    @NotNull
    private String author;
    @NotNull
    private Long year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    public Movie(){

    }

    public Movie(String movTitle, String movAuthor, Long movYear){
        this.title = movTitle;
        this.author = movAuthor;
        this.year = movYear;
    }

    public Long getMovieId() {
        return id;
    }

    public void setMovieId(Long id) {
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Store getStore(){
        return store;
    }
    public void setStore(Store store) {
        this.store = store;
    }
}

