package com.moviesexplorer.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

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
    private Date dateOfBirth;
    private String[] favouriteGenres;

    public User(Long id, String username, String email, String password, String firstName, String lastName, Date dateOfBirth, String[] favouriteGenres) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.favouriteGenres = favouriteGenres;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String[] getFavouriteGenres() {
        return favouriteGenres;
    }

    public void setFavouriteGenres(String[] favouriteGenres) {
        this.favouriteGenres = favouriteGenres;
    }
}
