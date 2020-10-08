package com.atm.demo.paymentmgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "com.atm.demo")
@EntityScan("com.atm.demo.entity")
@EnableMongoRepositories("com.atm.demo.repository")
public class PaymentManagementDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentManagementDemoApplication.class, args);
    }

}
