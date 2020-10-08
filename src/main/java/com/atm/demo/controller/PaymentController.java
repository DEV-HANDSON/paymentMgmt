package com.atm.demo.controller;

import com.atm.demo.entity.Payment;
import com.atm.demo.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List< Payment > getAllPayment() {
        return paymentRepository.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Payment add(@RequestBody Payment payment) {
       return paymentRepository.save(payment);
    }
}
