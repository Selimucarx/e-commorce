package com.example.ecommorce.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderItemDto(UUID id,
                           ProductDto product,
                           BigDecimal price,
                           int quantity) {
}
