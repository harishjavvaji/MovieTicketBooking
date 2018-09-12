package com.movietickets.booking.controllers;

import com.movietickets.booking.models.Movie;
import com.movietickets.booking.models.Theatre;
import com.movietickets.booking.services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TheatreController {
    @Autowired
    TheatreService theatreService;

    @RequestMapping(value = "/theatres",method = RequestMethod.GET)
    public List<Theatre> getAllTheatres(){

        return theatreService.getAllTheatres();
    }
    public List<Theatre> getTheatres(Movie movie){
        return theatreService.getTheatres(movie);

    }

}
