package com.moviesexplorer.movie;

import com.moviesexplorer.jpa.MovieRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieResource {
    private MovieRepository movieRepository;

    public MovieResource(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/movies")
    public void getAllMovies() {}

    @PostMapping("/movies")
    public void postMovie(@RequestBody Movie movie) {}

    @DeleteMapping("/movie/{id}")
    public void deleteMovie(@PathVariable Long id) {}

}
