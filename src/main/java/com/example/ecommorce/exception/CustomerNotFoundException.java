package com.example.ecommorce.exception;

import org.springframework.http.HttpStatus;

public class CustomerNotFoundException extends AbstractException{


    CustomerNotFoundException(String message) {
        super(message);
    }

    @Override
    HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
