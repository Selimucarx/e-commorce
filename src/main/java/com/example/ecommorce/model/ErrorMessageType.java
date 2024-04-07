package com.example.ecommorce.model;

public enum ErrorMessageType {

    INSUFFICIENT_STOCK("Yetersiz stok."),

    INVALID_REQUEST("İstek geçersiz. Lütfen girdiğiniz bilgileri kontrol ediniz."),
    CUSTOMER_NOT_FOUND("Customer bulunamadi."),
    PRODUCT_NOT_FOUND("Bu id ile product bulunamadi."),
    CUSTOMER_CART_NOT_FOUND("Customerin carti bulunamadi."),
    ORDER_NOT_FOUND("Bu id ile Order  bulunamadi."),

    GENERIC_ERROR("Sistem kaynaklı bir sorun oluştu. Lütfen daha sonra tekrar deneyiniz.");



    private final String message;

    ErrorMessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
