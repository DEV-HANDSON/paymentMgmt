package com.atm.demo.response;

import com.atm.demo.entity.Payment;
import lombok.Data;

@Data
public class PaymentResponse {

    private boolean successful;
    private String responseMessage;
    private String responseCode;
    private Payment payment;
}
