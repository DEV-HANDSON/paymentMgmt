package com.atm.demo.services;

import com.atm.demo.entity.Payment;
import com.atm.demo.repository.PaymentRepository;
import com.atm.demo.request.CreatePaymentRequest;
import com.atm.demo.response.PaymentResponse;
import com.atm.demo.util.DozzerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    public PaymentResponse createpayment(CreatePaymentRequest createPaymentRequest) {

        PaymentResponse res = new PaymentResponse();

        Payment pay = DozzerMapper.map(createPaymentRequest, Payment.class);
        pay = paymentRepository.save(pay);
        if (pay.getId() != null) {
            res.setResponseMessage("Successful !!!!!!");
            res.setPayment(pay);
        } else {
            res.setResponseMessage("Unsuccessful !!!!");
        }
        return res;
    }

    @Override
    public List<Payment> getAllpayment() {
        return paymentRepository.findAll();
    }

}
