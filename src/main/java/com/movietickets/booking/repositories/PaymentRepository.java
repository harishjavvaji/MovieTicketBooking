package com.movietickets.booking.repositories;

import com.movietickets.booking.models.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends CrudRepository<Payment,String> {
}
