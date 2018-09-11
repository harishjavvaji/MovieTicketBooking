package com.movietickets.booking.models;

public class Theatre {

    private String theatreName, city, time;
    private int zipcode;

    public Theatre() {
    }

    public Theatre(String theatreName, String city, String time, int zipcode) {
        this.theatreName = theatreName;
        this.city = city;
        this.time = time;
        this.zipcode = zipcode;
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
