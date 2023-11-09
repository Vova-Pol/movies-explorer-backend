package com.moviesexplorer.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.moviesexplorer.movie.Movie;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String email;
    @JsonIgnore
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String[] favouriteGenres;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
    private List<Movie> savedMovies;

    public User(Long id, String username, String email, String password, String firstName, String lastName, LocalDate dateOfBirth, String[] favouriteGenres, List<Movie> savedMovies) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.favouriteGenres = favouriteGenres;
        this.savedMovies = savedMovies;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Movie> getSavedMovies() {
        return savedMovies;
    }

    public void setSavedMovies(List<Movie> savedMovies) {
        this.savedMovies = savedMovies;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", favouriteGenres=" + Arrays.toString(favouriteGenres) +
                '}';
    }
}
