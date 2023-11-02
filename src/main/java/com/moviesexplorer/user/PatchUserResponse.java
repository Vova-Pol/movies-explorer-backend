package com.moviesexplorer.user;

import java.time.LocalDate;

public record PatchUserResponse(String firstName, String lastName, String username, String email, LocalDate dateOfBirth, String[] favouriteGenres) {
}
