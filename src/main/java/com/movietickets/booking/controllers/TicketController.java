package com.movietickets.booking.controllers;

import com.movietickets.booking.models.Customer;
import com.movietickets.booking.models.Movie;
import com.movietickets.booking.models.Theatre;
import com.movietickets.booking.models.Ticket;
import com.movietickets.booking.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TicketController {
    @Autowired
    TicketService ticketService;
    @Autowired
    MovieController movieController;
    @Autowired
    TheatreController theatreController;
    @RequestMapping(value = "/tickets",method = RequestMethod.GET)
    public List<Ticket> getAllTickets(){
        return ticketService.getAllTickets();
    }

//    @PostMapping(value = "/customers")
//    public void createTicket(@RequestBody Ticket ticket) {
//        ticketService.createTicket(ticket);
//    }

    @RequestMapping(value = "/cancelticket", method = RequestMethod.POST)
    public Customer deleteTicket(@RequestBody Customer customer){
        return ticketService.deleteTicket(customer);

    }


    @RequestMapping(value = "/ticket", method = RequestMethod.POST)
    public Ticket getTicket(@RequestBody Customer customer) {

        return ticketService.getTicket(customer);

    }

    @RequestMapping(value = "/tickets", method = RequestMethod.POST)
    public Ticket bookTicket(@RequestBody Ticket ticket) {
        return ticketService.bookTicket(ticket);

    }




}
