package com.example.ecommorce.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public record PriceHistoryDto(UUID id,
                              ProductDto product,
                              BigDecimal price,
                              BigDecimal orderItemPrice,
                              Date date) {
}
