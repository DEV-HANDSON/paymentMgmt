package com.atm.demo.request;


import lombok.Data;

@Data
public class CreatePaymentRequest {

    private String id;
    private Long transactionId;
    private Long orderId;
}
