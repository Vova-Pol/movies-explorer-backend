package com.moviesexplorer.jpa;

import com.moviesexplorer.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
