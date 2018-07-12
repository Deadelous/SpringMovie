package com.movie.movie.Controller;

import com.movie.movie.Exception.ResourceNotFoundException;
import com.movie.movie.Model.Actionmovie;
import com.movie.movie.Model.Movie;
import com.movie.movie.Model.Sciencemovie;
import com.movie.movie.Model.Store;
import com.movie.movie.Repository.ActionMovieRepository;
import com.movie.movie.Repository.ScienceMovieRepository;
import com.movie.movie.Repository.StoreRepository;
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

    @Autowired
    StoreRepository storeRepository;

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
    public String createActionmovie(@Valid @RequestBody Actionmovie actionmovie, Store store) {
        try {
            actionMovieRepository.save(actionmovie);
            storeRepository.save(store);
        }
        catch (Exception ex) {
            return "Error creating the movie: " + ex.toString();
        }
        return "movie = actionmovie is succesfully created!";
    }

    @DeleteMapping("/movie/actionmovie/{id}")
    public ResponseEntity<?> deleteActionmovie (@PathVariable(value = "id") Long ActionmovieId) {
        Actionmovie actionmovie = actionMovieRepository.findById(ActionmovieId)
                .orElseThrow(() -> new ResourceNotFoundException("Actionmovie", "id", ActionmovieId));

        actionMovieRepository.delete(actionmovie);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/movie/actionmovie/{id}")
    public Actionmovie getActionmovieId(@PathVariable(value = "id") Long ActionmovieId){
        return  actionMovieRepository.findById(ActionmovieId)
                .orElseThrow(() -> new ResourceNotFoundException("Actionmovie", "id", ActionmovieId));
    }

    @GetMapping("/actionmovies")
    public List<Actionmovie> getAll() {
        return (List<Actionmovie>) actionMovieRepository.findAll();
    }
}
