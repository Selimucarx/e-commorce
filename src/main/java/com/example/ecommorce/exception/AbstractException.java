package com.example.ecommorce.exception;

import org.springframework.http.HttpStatus;

public abstract class AbstractException extends RuntimeException{

    AbstractException(String message){
        super(message);
    }

    abstract HttpStatus getHttpStatus();
}
