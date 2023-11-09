package com.moviesexplorer.movie;

import com.moviesexplorer.exceptions.UserNotFoundException;
import com.moviesexplorer.jpa.MovieRepository;
import com.moviesexplorer.jpa.UserRepository;
import com.moviesexplorer.user.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    private MovieRepository movieRepository;
    private UserRepository userRepository;

    public MovieController(MovieRepository movieRepository, UserRepository userRepository) {
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @PostMapping("/movies")
    public Movie postMovie(HttpServletRequest request, @RequestBody Movie movie) {
        String username = (String) request.getAttribute("username");

        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new UserNotFoundException("User wasn't found")
        );

        movie.setOwner(user);
        System.out.println(movie);
        return movieRepository.save(movie);
    }

    @DeleteMapping("/movies/{id}")
    public void deleteMovie(@PathVariable Long id) {
         movieRepository.deleteById(id);
    }

}
