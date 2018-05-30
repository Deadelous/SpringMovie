package com.movie.MovieApp.Controller;

import com.movie.MovieApp.Exception.ResourceNotFoundException;
import com.movie.MovieApp.Model.Movie;
import com.movie.MovieApp.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {
    @Autowired
    MovieRepository movieRepository;


}
