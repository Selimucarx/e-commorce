package com.example.ecommorce.exception;

import com.example.ecommorce.model.ErrorMessageType;
import org.springframework.http.HttpStatus;

public class CustomerNotFoundException extends AbstractException{

    public CustomerNotFoundException(ErrorMessageType errorMessageType) {
        super(errorMessageType.getMessage());
    }

    public CustomerNotFoundException(String message) {
        super(message);
    }

    @Override
    HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
