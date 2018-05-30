package com.movie.MovieApp.Controller;

import com.movie.MovieApp.Exception.ResourceNotFoundException;
import com.movie.MovieApp.Model.Employee;
import com.movie.MovieApp.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;


}
