package com.atm.demo.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "payment")
public class Payment {

    private String id;
    private Long transactionId;
    private Long orderId;

}
