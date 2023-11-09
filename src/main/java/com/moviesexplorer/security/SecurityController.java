package com.moviesexplorer.security;

import com.moviesexplorer.exceptions.UserAlreadyExistsException;
import com.moviesexplorer.jpa.UserRepository;
import com.moviesexplorer.user.User;
import com.moviesexplorer.exceptions.UserNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class SecurityController {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtCore jwtCore;

    public SecurityController(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtCore jwtCore) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtCore = jwtCore;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody SignupRequest signupRequest) {

        // Проверка, существует ли уже пользователь

        if (userRepository.existsUserByUsername(signupRequest.getUsername())) {
            throw new UserAlreadyExistsException("User with such username already exists");
        }

        if (userRepository.existsUserByEmail(signupRequest.getEmail())) {
         throw new UserAlreadyExistsException("User with such email already exists");
        }

        // Создание нового пользователя

        String hashedPassword = passwordEncoder.encode(signupRequest.getPassword());
        User user = new User();
        user.setUsername(signupRequest.getUsername());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(hashedPassword);
        user.setFirstName("");
        user.setLastName("");
        user.setFavouriteGenres(new String[9]);
        user.setDateOfBirth(null);
        user.setSavedMovies(new ArrayList<>());
        userRepository.save(user);

        // Выпуск токена

        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            signupRequest.getUsername(), signupRequest.getPassword()
                    ));
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtCore.generateToken(authentication);

        return ResponseEntity.ok(new AuthResponse(user, jwt));

    }

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@Valid @RequestBody SigninRequest signinRequest) {
        String username = signinRequest.getUsername();
        String password = signinRequest.getPassword();

        User foundUser = userRepository.findByUsername(username)
                .orElseThrow(
                        () -> new UsernameNotFoundException(String.format("User '%s' not found", username))
                );

        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtCore.generateToken(authentication);


        return ResponseEntity.ok(new AuthResponse(foundUser, jwt));
    }

    @PostMapping("/signout")
    public ResponseEntity<?> signout() {

        SecurityContextHolder.getContext().setAuthentication(null);
        return ResponseEntity.ok(new SignoutResponse("You have successfully logged out"));
    }

    @PatchMapping("users/me/username")
    public ResponseEntity<?> patchUsername(@Valid @RequestBody UpdateUsernameRequest updateUsernameRequest, HttpServletRequest request) {
        String newUsername = updateUsernameRequest.getUsername();
        String password = updateUsernameRequest.getPassword();
        String currentUsername = (String) request.getAttribute("username");

        if (userRepository.existsUserByUsername(newUsername)) {
            throw new UserAlreadyExistsException("User with such username already exists");
        }

        User foundUser = userRepository.findByUsername(currentUsername).orElseThrow(
                () -> new UserNotFoundException("User wasn't found"));

            foundUser.setUsername(newUsername);
            User updatedUser = userRepository.save(foundUser);


            Authentication authentication = null;
            try {
                authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(newUsername, password));
            } catch (BadCredentialsException e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
            }

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtCore.generateToken(authentication);

            return ResponseEntity.ok(new AuthResponse(updatedUser, jwt));
    }
}
