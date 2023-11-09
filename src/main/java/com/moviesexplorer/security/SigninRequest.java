package com.moviesexplorer.security;

import jakarta.validation.constraints.Size;

public class SigninRequest {
    @Size(min = 2, max = 15, message = "username should be from 2 to 15 characters long")
    private String username;
    @Size(min = 7, message = "password should be at least 7 characters long")
    private String password;

    public SigninRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

