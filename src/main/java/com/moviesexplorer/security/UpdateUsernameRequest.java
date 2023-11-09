package com.moviesexplorer.security;

import jakarta.validation.constraints.Size;

public class UpdateUsernameRequest {
    @Size(min = 2, max = 15, message = "username should be from 2 to 15 characters long")
    private String username;
    private String password;

    public UpdateUsernameRequest(String username, String password) {
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
