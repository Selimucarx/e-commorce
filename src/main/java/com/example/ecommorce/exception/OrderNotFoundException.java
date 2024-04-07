package com.example.ecommorce.exception;

import com.example.ecommorce.model.ErrorMessageType;
import org.springframework.http.HttpStatus;

public class OrderNotFoundException extends AbstractException{

    public OrderNotFoundException(ErrorMessageType errorMessageType) {
        super(errorMessageType.getMessage());
    }

    public OrderNotFoundException(String message) {
        super(message);
    }

    @Override
    HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
