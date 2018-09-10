package com.movietickets.booking.models;

public class theatre {

    private String theatreName, City;
    private int zipcode;

    public theatre() {
    }

    public theatre(String theatreName, String city, int zipcode) {

        this.theatreName = theatreName;
        City = city;
        this.zipcode = zipcode;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }
}
