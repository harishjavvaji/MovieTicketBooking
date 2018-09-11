package com.movietickets.booking.controllers;

import com.movietickets.booking.models.Ticket;
import com.movietickets.booking.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TicketController {
    @Autowired
    TicketService ticketService;
    @RequestMapping(value = "/tickets",method = RequestMethod.GET)
    public List<Ticket> getAllTickets(){
        return ticketService.getAllTickets();
    }
}
