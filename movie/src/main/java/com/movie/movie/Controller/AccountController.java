package com.movie.movie.Controller;

import com.movie.movie.Exception.ResourceNotFoundException;
import com.movie.movie.Model.Account;
import com.movie.movie.Repository.AccountRepository;
import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm;

import io.jsonwebtoken.*;

import io.jsonwebtoken.JwtBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.crypto.spec.SecretKeySpec;

import javax.servlet.ServletException;
import javax.validation.Valid;
import javax.xml.bind.DatatypeConverter;
;
import java.security.SignatureException;
import java.util.Date;
import java.util.List;

import javax.xml.bind.DatatypeConverter;
import io.jsonwebtoken.Jwts;
import java.security.Key;



import static java.security.KeyRep.Type.SECRET;

@RestController
@RequestMapping("/api")
public class AccountController {
    Date date = new Date();
    Long time = date.getTime();
    Date expirationtime = new Date(time + 1200000 );

    @Autowired
    AccountRepository accountRepository;


    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @PostMapping("/accounts")
    public Account createAccount(@Valid @RequestBody Account account) {
        return accountRepository.save(account);
    }

    @GetMapping("/accounts/{id}")
    public Account getAccountId(@PathVariable(value = "id") Long accountId) {
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

        Account updatedAccount = accountRepository.save(account);
        return updatedAccount;
    }

    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable(value = "id") Long accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account", "id", accountId));

        accountRepository.delete(account);

        return ResponseEntity.ok().build();
    }

    @RequestMapping("/login")
    public String login(@RequestBody Account login) throws ServletException {
        Date date = new Date();
        Long time = date.getTime();
        Date expirationtime = new Date(time + 1200000 );


        String jwtToken = "";

        if (login.getUsername() == null || login.getPassword() == null) {
            throw new ServletException("Please fill in username and password");
        }

        String username = login.getUsername();
        String password = login.getPassword();

        Account user = accountRepository.findByUsername(username);

        if (user == null) {
            throw new ServletException("This user isn't found! Try again.");
        }

        String pwd = user.getPassword();

        if (!password.equals(pwd)) {
            throw new ServletException("Invalid login. Please check your name and password and fill it again.");
        }

        jwtToken = Jwts.builder().setSubject(username)
                .claim("username", user.getUsername())
                .claim("admin", user.getAdmin())
                .setIssuedAt(new Date())
                .setExpiration(expirationtime)
                .signWith(io.jsonwebtoken.SignatureAlgorithm.HS256, "secretkey").compact();

        return jwtToken;
    }

    @GetMapping("/login/verify")
    public String verify(@RequestHeader String token, Account login) {
        Date date = new Date();
        Long time = date.getTime();
        Date expirationtime = new Date(time + 1200000 );


        String username = login.getUsername();
        Claims claims = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody().setExpiration(expirationtime);
        claims.get("username");
        boolean bool = (boolean) claims.get("admin");

        return claims.toString() + expirationtime.toString();
    }
}





