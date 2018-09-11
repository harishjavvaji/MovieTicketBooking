package com.movietickets.booking.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Customer {
    @NotNull
    @Column(name = "firstname")
    @NotNull
    private String firstName;
    @Column(name = "lastname")
    @NotNull
    private String lastName;
    @Column(name = "email")
    @NotNull
    private String email;
    @Id
    @Column(name = "username")
    private String userName;
    @NotNull
    @Column(name = "password")
    private String password;


    public Customer() {
public class Customer {
   private String firstName;
   private String lastName;
   private String email;
   private String userName;
   private String password;

    public Customer(){

    }

    public Customer(String firstName, String lastName, String email, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
