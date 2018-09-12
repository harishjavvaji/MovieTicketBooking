package com.movietickets.booking.services;

import com.movietickets.booking.models.Movie;
import com.movietickets.booking.models.Theatre;
import com.movietickets.booking.repositories.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
public class TheatreService {
    @Autowired
    TheatreRepository theatreRepository;
    public List<Theatre> getAllTheatres(){
        List<Theatre> theatres=new ArrayList<>();
        theatreRepository.findAll().forEach(new Consumer<Theatre>() {
            @Override
            public void accept(Theatre theatre) {
                theatres.add(theatre);
            }
        });
        return theatres;
    }
//    public List<Theatre> getTheatres(Movie movie) {
////        List<Theatre> list=theatreRepository.;
//        return list;
//    }

}
