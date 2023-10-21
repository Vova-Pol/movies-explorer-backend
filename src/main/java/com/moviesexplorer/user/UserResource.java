package com.moviesexplorer.user;

import com.moviesexplorer.jpa.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserResource {

    private UserRepository userRepository;

    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/me")
    public Optional<User> getUser(HttpServletRequest request) {
        String username = (String) request.getAttribute("username");

        Optional<User> foundUser = userRepository.findByUsername(username);
        if (foundUser.isEmpty()) throw new UserNotFoundException("User wasn't found");

        return foundUser;
    }


}
