package com.movie.MovieApp.Repository;

import com.movie.MovieApp.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
    Account findByUsername(String username);
}
