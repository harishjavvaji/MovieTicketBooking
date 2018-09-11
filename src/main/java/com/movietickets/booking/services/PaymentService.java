package com.movietickets.booking.services;

import com.movietickets.booking.models.Payment;
import com.movietickets.booking.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
public class PaymentService {
    PaymentRepository paymentRepository;
    public List<Payment> getAllPayments(){
        List<Payment> payments=new ArrayList<>();
        paymentRepository.findAll().forEach(new Consumer<Payment>() {
            @Override
            public void accept(Payment payment) {
                payments.add(payment);
            }
        });
        return payments;
    }
}

