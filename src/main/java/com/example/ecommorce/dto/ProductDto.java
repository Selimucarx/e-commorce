package com.example.ecommorce.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public record ProductDto(UUID id,
                         Date createDate,
                         String name,
                         int stock,
                         BigDecimal price,
                         String description
) {
}
