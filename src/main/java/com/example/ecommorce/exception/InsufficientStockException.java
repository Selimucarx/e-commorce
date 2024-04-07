package com.example.ecommorce.exception;

import com.example.ecommorce.model.ErrorMessageType;
import org.springframework.http.HttpStatus;

public class InsufficientStockException extends AbstractException {
    public InsufficientStockException(ErrorMessageType errorMessageType) {
        super(errorMessageType.getMessage());
    }

    public InsufficientStockException(String message) {
        super(message);
    }

    @Override
    HttpStatus getHttpStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
