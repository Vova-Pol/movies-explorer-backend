package com.moviesexplorer.security;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class SignupRequest {
    @Size(min = 2, max = 15, message = "username should be from 2 to 15 characters long")
    private String username;
    @Email(message = "email is incorrect")
    private String email;
    @Size(min = 7, message = "password should be at least 7 characters long")
    private String password;

    public SignupRequest(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
