package com.movietickets.booking.repositories;

import com.movietickets.booking.models.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends CrudRepository<Ticket,String> {
}
