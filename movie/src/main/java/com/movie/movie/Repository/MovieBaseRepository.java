package com.movie.movie.Repository;

import com.movie.movie.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovieBaseRepository<T extends Movie> extends CrudRepository<T,Long>
{

}
