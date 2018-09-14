package com.movietickets.booking.models;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "ticketdata")
public class Ticket {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "numberofadulttickets")
    private int numberOfAdultTickets;

    @Column(name = "adultticketprice")
    private final double adultTicketPrice = 12.75;

    @Column(name = "numberofchildtickets")
    private int numberOfChildTickets;

    @Column(name = "childticketprice")
    private final double childTicketPrice = 8.75;

    @Column(name = "totalprice")
    private int totalPrice;

    @Column(name = "username")
    private String userName;

    public Ticket(int numberOfAdultTickets, int numberOfChildTickets, int totalPrice, String userName) {
        this.numberOfAdultTickets = numberOfAdultTickets;
        this.numberOfChildTickets = numberOfChildTickets;
        this.totalPrice = totalPrice;
        this.userName = userName;
    }

    public Ticket() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfAdultTickets() {
        return numberOfAdultTickets;
    }

    public void setNumberOfAdultTickets(int numberOfAdultTickets) {
        this.numberOfAdultTickets = numberOfAdultTickets;
    }

    public double getAdultTicketPrice() {
        return adultTicketPrice;
    }

    public int getNumberOfChildTickets() {
        return numberOfChildTickets;
    }

    public void setNumberOfChildTickets(int numberOfChildTickets) {
        this.numberOfChildTickets = numberOfChildTickets;
    }

    public double getChildTicketPrice() {
        return childTicketPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
