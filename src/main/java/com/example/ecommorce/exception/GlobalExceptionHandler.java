package com.example.ecommorce.exception;

import com.example.ecommorce.dto.ErrorDto;
import com.example.ecommorce.model.ErrorMessageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Object> handleCustomerNotFoundException(CustomerNotFoundException ex, WebRequest request) {
        ErrorDto errorDto = new ErrorDto(

                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ErrorMessageType.CUSTOMER_NOT_FOUND.getMessage(),
                new Date()
        );
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object> handleProductNotFoundException(ProductNotFoundException ex, WebRequest request) {
        ErrorDto errorDto = new ErrorDto(

                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ErrorMessageType.CUSTOMER_NOT_FOUND.getMessage(),
                new Date()
        );
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(CustomerCartNotFoundException.class)
    public ResponseEntity<Object> handleCustomerCartNotFoundException(CustomerCartNotFoundException ex, WebRequest request) {
        ErrorDto errorDto = new ErrorDto(

                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ErrorMessageType.CUSTOMER_NOT_FOUND.getMessage(),
                new Date()
        );
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<Object> handleOrderNotFoundException(OrderNotFoundException ex, WebRequest request) {
        ErrorDto errorDto = new ErrorDto(

                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ErrorMessageType.CUSTOMER_NOT_FOUND.getMessage(),
                new Date()
        );
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InsufficientStockException.class)
    public ResponseEntity<Object> handleInsufficientStockException(InsufficientStockException ex, WebRequest request) {
        ErrorDto errorDto = new ErrorDto(

                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ErrorMessageType.CUSTOMER_NOT_FOUND.getMessage(),
                new Date()
        );
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }


    // Diger tum exceptionlar burada yakalanacak.
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalException(Exception ex, WebRequest request) {
        ErrorDto errorDto = new ErrorDto(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                ErrorMessageType.GENERIC_ERROR.getMessage(),
                new Date()
        );
        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
