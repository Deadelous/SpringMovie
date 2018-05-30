package com.movie.MovieApp.Controller;

import com.movie.MovieApp.Exception.ResourceNotFoundException;
import com.movie.MovieApp.Model.Store;
import com.movie.MovieApp.Repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StoreController {
    @Autowired
    StoreRepository storeRepository;

    @GetMapping("/stores")
    public List<Store> getAllStores(){
        return storeRepository.findAll();
    }

    @PostMapping("/stores")
    public Store createStores(@Valid @RequestBody Store store){
        return storeRepository.save(store);
    }

    @GetMapping("/stores/{id}")
    public Store getStoreId(@PathVariable(value = "id") Long storeId){
        return storeRepository.findById(storeId)
                .orElseThrow(() -> new ResourceNotFoundException("Store", "id", storeId));
    }

    @PutMapping("/stores/{id}")
    public Store updateStore(@PathVariable(value = "id") Long storeId,
                             @Valid @RequestBody Store storeDetails) {
        return null;
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable(value = "id") Long accountId) {
     return null;
    }
}
