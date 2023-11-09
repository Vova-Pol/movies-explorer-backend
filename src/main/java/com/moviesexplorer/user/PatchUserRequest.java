package com.moviesexplorer.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class PatchUserRequest {
    @Size(min = 2, max = 15, message = "first name should be from 2 to 15 characters long")
    private String firstName;
    @Size(min = 2, max = 15, message = "last name should be from 2 to 15 characters long")
    private String lastName;
    @Email(message = "email is incorrect")
    private String email;
    @Past(message = "birth date should be in past")
    private LocalDate dateOfBirth;
    private String[] favouriteGenres;

    public PatchUserRequest(String firstName, String lastName, String email, LocalDate dateOfBirth, String[] favouriteGenres) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.favouriteGenres = favouriteGenres;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String[] getFavouriteGenres() {
        return favouriteGenres;
    }

    public void setFavouriteGenres(String[] favouriteGenres) {
        this.favouriteGenres = favouriteGenres;
    }
}
