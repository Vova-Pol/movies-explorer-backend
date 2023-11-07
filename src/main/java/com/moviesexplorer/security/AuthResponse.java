package com.moviesexplorer.security;
import com.moviesexplorer.user.User;

public record AuthResponse (User user, String jwt ) {}
