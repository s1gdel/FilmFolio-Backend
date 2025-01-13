package com.learn.learn;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MovieRepository extends JpaRepository<Movie, UUID> {

    // Find movies by exact genre match (not recommended for your use case)
    List<Movie> findByGenres(String genres);

    // Custom query to find movies where the genres field contains the specified genre
    @Query("SELECT m FROM Movie m WHERE LOWER(m.genres) LIKE LOWER(CONCAT('%', :genre, '%')) ORDER BY m.rating DESC, m.numRaters DESC")
    List<Movie> findByGenresContainingIgnoreCaseOrderByRatingDescNumRatersDesc(@Param("genre") String genre);
}