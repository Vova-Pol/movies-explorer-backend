package com.moviesexplorer.security;

public class SignoutResponse {
    private String message;

    public SignoutResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
