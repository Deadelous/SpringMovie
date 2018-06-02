package com.movie.MovieApp.Controller;

import com.movie.MovieApp.Exception.ResourceNotFoundException;
import com.movie.MovieApp.Model.Actionmovie;
import com.movie.MovieApp.Model.Movie;
import com.movie.MovieApp.Model.Sciencemovie;
import com.movie.MovieApp.Model.Store;
import com.movie.MovieApp.Repository.ActionMovieRepository;
import com.movie.MovieApp.Repository.ScienceMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/api")
public class MovieController {
    @Autowired
    ScienceMovieRepository scienceMovieRepository;

    @Autowired
    ActionMovieRepository  actionMovieRepository;

    @PostMapping("/movie/create/science")
    @ResponseBody
    public String createSciencemovie(@Valid @RequestBody Sciencemovie sciencemovie) {
        try {
            scienceMovieRepository.save(sciencemovie);
        }
        catch (Exception ex) {
            return "Error creating the movie: " + ex.toString();
        }
        return "movie = sciencemovie is succesfully created!";
    }

    @PostMapping("/movie/create/action")
    @ResponseBody
    public String createActionmovie(@Valid @RequestBody Actionmovie actionmovie) {
        try {
            actionMovieRepository.save(actionmovie);
        }
        catch (Exception ex) {
            return "Error creating the movie: " + ex.toString();
        }
        return "movie = actionmovie is succesfully created!";
    }

    @DeleteMapping("/actionmovie/{id}")
    public ResponseEntity<?> deleteActionmovie (@PathVariable(value = "id") Long ActionmovieId) {
        Actionmovie actionmovie = actionMovieRepository.findById(ActionmovieId)
                .orElseThrow(() -> new ResourceNotFoundException("Actionmovie", "id", ActionmovieId));

        actionMovieRepository.delete(actionmovie);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/actionmovie/{id}")
    public Actionmovie getActionmovieId(@PathVariable(value = "id") Long ActionmovieId){
        return  actionMovieRepository.findById(ActionmovieId)
                .orElseThrow(() -> new ResourceNotFoundException("Actionmovie", "id", ActionmovieId));
    }
}
