package com.movie.movie.Controller;

import com.movie.movie.Exception.ResourceNotFoundException;
import com.movie.movie.Model.Author;
import com.movie.movie.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class AuthorController {
    @Autowired
    AuthorRepository authorRepository;

    @GetMapping("/Authors")
    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    @PostMapping("/Authors")
    public Author createAuthor(@Valid @RequestBody Author author){
        return authorRepository.save(author);
    }

    @GetMapping("/Authors/{id}")
    public Author getAuthorId(@PathVariable(value = "id") Long authorId){
        return authorRepository.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Author", "id", authorId));
    }

    @PutMapping("/Authors{id}")
    public Author updateAuthor(@PathVariable(value = "id") Long authorId,
                                   @Valid @RequestBody Author authorDetails) {

        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Author", "id", authorId));

        author.setName(authorDetails.getName());
        author.setAge(authorDetails.getAge());

        Author updatedAuthor= authorRepository.save(author);
        return updatedAuthor;
    }

    @DeleteMapping("/Authors/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable(value = "id") Long authorId) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Author", "id", authorId));


        authorRepository.delete(author);

        return ResponseEntity.ok().build();

    }
}
