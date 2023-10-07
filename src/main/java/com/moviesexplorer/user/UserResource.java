package com.moviesexplorer.user;

import com.moviesexplorer.jpa.UserRepository;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/users/{id}")
    public Optional<User> getUser(@PathVariable Long id) {
        Optional<User> foundUser = userRepository.findById(id);
        if (foundUser.isEmpty()) throw new RuntimeException("User wasn't found");
        return foundUser;
    }

    @PostMapping("/users")
    public User postUser(@RequestBody User user) {
        userRepository.save(user);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
