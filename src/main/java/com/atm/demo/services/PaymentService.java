package com.atm.demo.services;

import com.atm.demo.entity.Payment;
import com.atm.demo.request.CreatePaymentRequest;
import com.atm.demo.response.PaymentResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PaymentService {

    PaymentResponse createpayment(CreatePaymentRequest createPaymentRequest);

    List<Payment> getAllpayment();
}
