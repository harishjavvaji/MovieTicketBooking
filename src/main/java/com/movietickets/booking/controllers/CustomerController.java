package com.movietickets.booking.controllers;

import com.movietickets.booking.models.Customer;
import com.movietickets.booking.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/customers",method = RequestMethod.GET)
    public List<Customer> getAllCustomers(){

        return customerService.getAllCustomers();


    }
    @PostMapping(value = "/customers")
    public void createCustomer(@RequestBody Customer customer) {
         customerService.createCustomer(customer);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public Customer getCustomer(@RequestBody Customer customer) {

        return customerService.getCustomer(customer);

    }

}