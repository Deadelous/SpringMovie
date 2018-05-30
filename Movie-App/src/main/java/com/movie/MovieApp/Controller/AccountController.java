package com.movie.MovieApp.Controller;

import com.movie.MovieApp.Exception.ResourceNotFoundException;
import com.movie.MovieApp.Model.Account;
import com.movie.MovieApp.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountController {
    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/accounts")
    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    @PostMapping("/accounts")
    public Account createAccount(@Valid @RequestBody Account account){
        return accountRepository.save(account);
    }

    @GetMapping("/accounts/{id}")
    public Account getAccountId(@PathVariable(value = "id") Long accountId){
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account", "id", accountId));
    }

    @PutMapping("/accounts/{id}")
    public Account updateAccount(@PathVariable(value = "id") Long accountId,
                           @Valid @RequestBody Account accountDetails) {

       Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account", "id", accountId));

        account.setAccountBalance(accountDetails.getAccountBalance());
        account.setAccountCreation(accountDetails.getAccountCreation());

        Account updatedNote = accountRepository.save(account);
        return updatedNote;
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable(value = "id") Long accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account", "id", accountId));

        accountRepository.delete(account);

        return ResponseEntity.ok().build();
    }
}
