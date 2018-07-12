package com.movie.movie.Controller;

import com.movie.movie.Exception.ResourceNotFoundException;
import com.movie.movie.Model.Store;
import com.movie.movie.Repository.StoreRepository;
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

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new ResourceNotFoundException("Store", "id", storeId));

        store.setAdress(storeDetails.getAdress());
        store.setName(storeDetails.getName());
        store.setMovieamount(storeDetails.getMovieamount());
        store.setMovies(storeDetails.getMovies());

        Store updatedStore= storeRepository.save(store);
        return updatedStore;
    }

    @DeleteMapping("/stores/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable(value = "id") Long storeId) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new ResourceNotFoundException("Store", "id", storeId));

        storeRepository.delete(store);

        return ResponseEntity.ok().build();
    }
}
