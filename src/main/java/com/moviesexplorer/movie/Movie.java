package com.moviesexplorer.movie;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Movie {
    @Id
    private Long id;
    private String nameRU;
    private String nameEN;
    private String director;
    private String country;
    private String year;
    private int duration;
    private String description;
    private String trailerLink;
    private LocalDate created_at;
    private LocalDate updated_at;
    private MovieImage image;

    public Movie() {
    }

    public Movie(Long id, String nameRU, String nameEN, String director, String country, String year, int duration, String description, String trailerLink, LocalDate created_at, LocalDate updated_at, MovieImage image) {
        this.id = id;
        this.nameRU = nameRU;
        this.nameEN = nameEN;
        this.director = director;
        this.country = country;
        this.year = year;
        this.duration = duration;
        this.description = description;
        this.trailerLink = trailerLink;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameRU() {
        return nameRU;
    }

    public void setNameRU(String nameRU) {
        this.nameRU = nameRU;
    }

    public String getNameEN() {
        return nameEN;
    }

    public void setNameEN(String nameEN) {
        this.nameEN = nameEN;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTrailerLink() {
        return trailerLink;
    }

    public void setTrailerLink(String trailerLink) {
        this.trailerLink = trailerLink;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public LocalDate getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDate updated_at) {
        this.updated_at = updated_at;
    }

    public MovieImage getImage() {
        return image;
    }

    public void setImage(MovieImage image) {
        this.image = image;
    }
}