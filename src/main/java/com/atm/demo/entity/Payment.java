package com.atm.demo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.aggregation.ConvertOperators;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "payment")
public class Payment {

    private int Id;
    private Long TransactionId;
    private Long OrderId;

}
