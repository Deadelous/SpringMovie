package com.movie.movie.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@DiscriminatorColumn(name="Movie")
@Table(name = "actionmovies")
public class Actionmovie extends Movie implements Serializable{
    private String summary;

    public Actionmovie(){

    }

    public Actionmovie(String movTitle, String movAuthor, int movYear, String summary) {
        super(movTitle, movAuthor, movYear);
        this.summary = summary;
    }

    public String getSummary(){
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
