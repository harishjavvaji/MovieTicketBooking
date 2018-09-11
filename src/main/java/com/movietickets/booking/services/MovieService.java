package com.movietickets.booking.services;

import com.movietickets.booking.models.Movie;
import com.movietickets.booking.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public List<Movie> getAllMovies(){
        List<Movie> movies=new ArrayList<>();
        movieRepository.findAll().forEach(new Consumer<Movie>() {
            @Override
            public void accept(Movie movie) {
                movies.add(movie);
            }
        });
        return movies;
    }

}

