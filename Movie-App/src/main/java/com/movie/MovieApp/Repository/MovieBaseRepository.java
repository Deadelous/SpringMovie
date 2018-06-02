package com.movie.MovieApp.Repository;

import com.movie.MovieApp.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;


@Repository
public interface MovieBaseRepository<T extends Movie> extends CrudRepository<T,Long>
{

}
