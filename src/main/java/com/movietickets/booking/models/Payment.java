package com.movietickets.booking.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "paymentdata")
public class Payment {

    @Id
    @Column(name = "cardnumber")
   private String cardNumber;
    @Column(name = "cardholdername")
   private String cardHolderName;
    @Column(name = "month")
   private int month;
    @Column(name = "year")
   private int year;
    @Column(name = "username")
    private String userName;

    public Payment() {
    }

    public Payment(String cardNumber, String cardHolderName, int month, int year, String userName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.month = month;
        this.year = year;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
