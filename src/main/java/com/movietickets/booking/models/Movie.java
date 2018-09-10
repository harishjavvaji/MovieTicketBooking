package com.movietickets.booking.models;

public class Movie {

    private String movieName, actorName;
    private String genre, length;

    public Movie(String movieName, String actorName, String genre, String length) {
        this.movieName = movieName;
        this.actorName = actorName;
        this.genre = genre;
        this.length = length;
    }

    public Movie() {
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
}
