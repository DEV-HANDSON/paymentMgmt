package com.atm.demo.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
public class APIException {

    private final String exceptionMessage;
    private final HttpStatus httpStatus;
    private final ZonedDateTime zonedDateTime;

    public APIException(String exceptionMessage, HttpStatus httpStatus, ZonedDateTime zonedDateTime) {
        this.exceptionMessage = exceptionMessage;
        this.httpStatus = httpStatus;
        this.zonedDateTime = zonedDateTime;
    }


}
