package com.moviesexplorer.user;

import java.time.LocalDate;

public record PatchUserRequest(String firstName, String lastName, String email, LocalDate dateOfBirth, String[] favouriteGenres ) {
}
