package com.example.ecommorce.exception;

import com.example.ecommorce.model.ErrorMessageType;
import org.springframework.http.HttpStatus;

public class CustomerCartNotFoundException extends AbstractException{

    public CustomerCartNotFoundException(ErrorMessageType errorMessageType) {
        super(errorMessageType.getMessage());
    }

    public CustomerCartNotFoundException(String message) {
        super(message);
    }

    @Override
    HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }
}


