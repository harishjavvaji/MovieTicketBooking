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

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public int registerCustomer(@RequestBody Customer customer) {
        return customerService.registerCustomer(customer);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public Customer validateCustomer(@RequestBody Customer customer) {

        return customerService.validateCustomer(customer);
    }

}