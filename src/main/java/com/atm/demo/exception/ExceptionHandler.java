package com.atm.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Object> apiRequestException(NoDataFoundException exception){
        HttpStatus internalServer = HttpStatus.INTERNAL_SERVER_ERROR;
        APIException apiException = new APIException(exception.getMessage(),
                internalServer,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiException, internalServer);
    }
}
