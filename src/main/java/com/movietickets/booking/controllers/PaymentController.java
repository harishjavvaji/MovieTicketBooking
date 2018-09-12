package com.movietickets.booking.controllers;

import com.movietickets.booking.models.Payment;
import com.movietickets.booking.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @RequestMapping(value = "/payments",method = RequestMethod.GET)
    public List<Payment> getAllPayments(){
        return paymentService.getAllPayments();
    }


    @PostMapping(value = "/payments")
    public void createPayment(@RequestBody Payment payment) {
         paymentService.createPayment(payment);
    }

}
