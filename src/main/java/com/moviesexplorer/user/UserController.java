package com.moviesexplorer.user;

import com.moviesexplorer.exceptions.UserNotFoundException;
import com.moviesexplorer.jpa.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/me")
    public User getUser(HttpServletRequest request) {
        String username = (String) request.getAttribute("username");

       return userRepository.findByUsername(username).orElseThrow(
                () -> new UserNotFoundException("User wasn't found")
        );
    }

    // Для тестов
    @GetMapping("/test")
    public SecurityContext test() {
        return SecurityContextHolder.getContext();
    }

    @PatchMapping("/users/me/profile")
    public PatchUserResponse patchUser(HttpServletRequest request, @RequestBody PatchUserRequest body ) {
        String username = (String) request.getAttribute("username");

        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new UserNotFoundException("User wasn't found")
        );

        if (!body.lastName().equals(user.getLastName())) user.setLastName(body.lastName());
        if (!body.firstName().equals(user.getFirstName())) user.setFirstName(body.firstName());
        if (!body.email().equals(user.getEmail())) user.setEmail(body.email());
        if (!body.dateOfBirth().equals(user.getDateOfBirth())) user.setDateOfBirth(body.dateOfBirth());
        if (!body.favouriteGenres().equals(user.getFavouriteGenres())) user.setFavouriteGenres(body.favouriteGenres());
        User savedUser = userRepository.save(user);

        return new PatchUserResponse(
                savedUser.getFirstName(),
                savedUser.getLastName(),
                savedUser.getUsername(),
                savedUser.getEmail(),
                savedUser.getDateOfBirth(),
                savedUser.getFavouriteGenres()
        );
    }
}
