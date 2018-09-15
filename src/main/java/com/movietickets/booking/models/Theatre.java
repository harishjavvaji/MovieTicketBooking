package com.movietickets.booking.models;

import javax.persistence.*;

@Entity
@Table(name = "theatredata")
public class Theatre {
    @Column(name = "theatrename")
    private String theatreName;
    @Column(name = "city")
    private String city;
    @Column(name = "time")
    private String time;
    @Column(name = "zipcode")
    private int zipcode;
    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    @Column(name = "moviename")
    private String movieName;

    public Theatre() {
    }

    public Theatre(String theatreName, String city, String time, int zipcode) {
        this.theatreName = theatreName;
        this.city = city;
        this.time = time;
        this.zipcode = zipcode;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }
}
