package com.movietickets.booking.repositories;

import com.movietickets.booking.models.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface TicketRepository extends CrudRepository<Ticket,String> {

    @Transactional
    public void deleteByUserName(String userName);

}
