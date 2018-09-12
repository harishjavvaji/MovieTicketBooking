package com.movietickets.booking.controllers;

import com.movietickets.booking.models.Theatre;
import com.movietickets.booking.models.Ticket;
import com.movietickets.booking.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketController {
    @Autowired
    TicketService ticketService;
    @RequestMapping(value = "/tickets",method = RequestMethod.GET)
    public List<Ticket> getAllTickets(){
        return ticketService.getAllTickets();
    }

    @PostMapping(value = "/customers")
    public void createTicket(@RequestBody Ticket ticket) {
        ticketService.createTicket(ticket);
    }

    @RequestMapping(value = "/employee")
    public void deleteTicket(@RequestParam String userName){
        ticketService.deleteTicket(userName);//http://localhost:8080/employee?empId=21
    }


}
