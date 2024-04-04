package com.example.ecommorce.dto;

import java.math.BigDecimal;

public record ProductDto(String name,
                         int stock,
                         BigDecimal price,
                         String description
) {}
