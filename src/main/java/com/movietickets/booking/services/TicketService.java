package com.movietickets.booking.services;

import com.movietickets.booking.models.Ticket;
import com.movietickets.booking.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;
    public List<Ticket> getAllTickets(){
        List<Ticket> tickets= new ArrayList<>();
        ticketRepository.findAll().forEach(new Consumer<Ticket>() {
            @Override
            public void accept(Ticket ticket) {
                tickets.add(ticket);
            }
        });
        return tickets;
    }

}
