package com.atm.demo.controller;

import com.atm.demo.entity.Payment;
import com.atm.demo.exception.NoDataFoundException;
import com.atm.demo.request.CreatePaymentRequest;
import com.atm.demo.response.PaymentResponse;
import com.atm.demo.services.PaymentService;
import com.atm.demo.services.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @Autowired
    private PaymentServiceImpl paymentService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public PaymentResponse add(@RequestBody CreatePaymentRequest createPaymentRequest) {

        PaymentResponse res = new PaymentResponse();
        res = paymentService.createpayment(createPaymentRequest);
        return res;
    }

    @RequestMapping(value = "/getPayments", method = RequestMethod.GET)
    public List<Payment> getAllPayment() {
        List<Payment> list = list = paymentService.getAllpayment();
        if (CollectionUtils.isEmpty(list)) {
            throw new NoDataFoundException("No Data Found");
        }
        return list;
    }
}
