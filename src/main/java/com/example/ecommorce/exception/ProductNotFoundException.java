package com.example.ecommorce.exception;

import com.example.ecommorce.model.ErrorMessageType;
import org.springframework.http.HttpStatus;

public class ProductNotFoundException extends AbstractException{

    public ProductNotFoundException(ErrorMessageType errorMessageType) {
        super(errorMessageType.getMessage());
    }

    public ProductNotFoundException(String message) {
        super(message);
    }

    @Override
    HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
