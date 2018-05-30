package com.movie.MovieApp.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sciencemovies")
public class Sciencemovie  extends Movie implements Serializable {
    private int duration;

    public Sciencemovie(){

    }

    public Sciencemovie(String movTitle, String movAuthor, int movYear, int duration) {
        super(movTitle, movAuthor, movYear);
        this.duration = duration;
    }
}

