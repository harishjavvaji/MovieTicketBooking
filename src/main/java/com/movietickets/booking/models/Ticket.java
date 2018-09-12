package com.movietickets.booking.models;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ticketdata")
public class Ticket {
    @Id
    @Column(name = "username")
    private String userName;
    @Column(name = "moviename")
    private String movieName;
    @Column(name = "theatrename")
    private String theatreName;

    public  Ticket(){

    }

    public Ticket(String userName, String movieName, String theatreName) {
        this.userName = userName;
        this.movieName = movieName;
        this.theatreName = theatreName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
}
