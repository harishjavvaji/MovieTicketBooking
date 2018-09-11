package com.movietickets.booking.models;

import org.springframework.beans.factory.annotation.Autowired;

public class Ticket {
    private String userName;
    @Autowired
    private Movie movie;
    @Autowired
    private Theatre theatre;

    public  Ticket(){

    }

    public Ticket(String userName, Movie movie, Theatre theatre) {
        this.userName = userName;
        this.movie = movie;
        this.theatre = theatre;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }
}
