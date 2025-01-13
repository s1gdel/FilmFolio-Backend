package com.learn.learn;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/movies")
public class MainController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public List<Movie> listMovies(
            @RequestParam(name = "genre", required = false) String genre
    ) {
        if (genre != null && !genre.isEmpty()) {
            // Fetch movies filtered by genre
            return movieRepository.findByGenresContainingIgnoreCaseOrderByRatingDescNumRatersDesc(genre);
        } else {
            // Fetch all movies
            return movieRepository.findAll();
        }
    }

    @GetMapping("/top-rated")
    public List<Movie> getTopRatedMoviesByGenre(
            @RequestParam(name = "genre", required = true) String genre
    ) {
        // Fetch top 3 movies by genre, ordered by rating descending and then by number of raters descending
        return movieRepository.findByGenresContainingIgnoreCaseOrderByRatingDescNumRatersDesc(genre).stream()
                .limit(3)
                .collect(Collectors.toList());
    }
}