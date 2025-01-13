package com.learn.learn; // Update with your package name

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "movies") // Map to the "movies" table
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "UUID DEFAULT gen_random_uuid()", nullable = false, updatable = false)
    private UUID id; // UUID primary key

    @Column(name = "name", nullable = false) 
    private String name; 

    @Column(name = "movie_rated") 
    private String movieRated; 

    @Column(name = "run_length") 
    private String runLength; 

    @Column(name = "genres") 
    private String genres; 

    @Column(name = "release_date") 
    private String releaseDate; 

    @Column(name = "rating") 
    private double rating; 

    @Column(name = "num_raters") 
    private int numRaters; 

   
    public Movie() {
    }

    // Getters and setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMovieRated() {
        return movieRated;
    }

    public void setMovieRated(String movieRated) {
        this.movieRated = movieRated;
    }

    public String getRunLength() {
        return runLength;
    }

    public void setRunLength(String runLength) {
        this.runLength = runLength;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getNumRaters() {
        return numRaters;
    }

    public void setNumRaters(int numRaters) {
        this.numRaters = numRaters;
    }

}
