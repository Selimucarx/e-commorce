package com.example.ecommorce.dto;

import java.util.Date;

public record ErrorDto(int resultCode,
                       String result,
                       String errorMessage,
                       Date time) {
}
