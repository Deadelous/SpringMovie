package com.movie.MovieApp.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "employees")
public class Employee implements Serializable {
    @Id @GeneratedValue

    private Long id;
    private String name;

    public Employee(){

    }

    public Employee(String Employeename){
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
}
