package com.movietickets.booking.services;

import com.movietickets.booking.models.Customer;
import com.movietickets.booking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer>  getAllCustomers(){
        List<Customer> customers=new ArrayList<>();
        customerRepository.findAll().forEach(new Consumer<Customer>() {
            @Override
            public void accept(Customer customer) {
                customers.add(customer);
            }
        });
        return customers;
    }

}