package com.example.ecommorce.exception;

import org.springframework.http.HttpStatus;

public class GenericException extends AbstractException{

    GenericException(String message){
        super(message);
    }
    @Override
    HttpStatus getHttpStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
