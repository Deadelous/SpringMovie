package com.movie.MovieApp.Repository;

import com.movie.MovieApp.Model.Account;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class AccountDetail {
    private AccountRepository accountRepository;

    public AccountDetail (AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public Account loadUserByUsername(String account) throws UsernameNotFoundException {
        Account accountUser = accountRepository.findByUsername(account);
        if (account == null) {
            throw new UsernameNotFoundException(account);
        }
        return new Account(accountUser.getUsername(), accountUser.getPassword());
    }


}
