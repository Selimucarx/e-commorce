package com.example.ecommorce.model;

public enum ErrorMessageType {

    INVALID_REQUEST("İstek geçersiz. Lütfen girdiğiniz bilgileri kontrol ediniz."),
    CUSTOMER_NOT_FOUND("Customer bulunamadi."),
    GENERIC_ERROR("Sistem kaynaklı bir sorun oluştu. Lütfen daha sonra tekrar deneyiniz."),
    FORBIDDEN("Yetkiniz yoktur."),
    BAD_REQUEST("Geçersiz istek. Lütfen girdilerinizi kontrol ediniz.");



    private final String message;

    ErrorMessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
