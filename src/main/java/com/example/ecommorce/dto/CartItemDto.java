package com.example.ecommorce.dto;

import java.util.UUID;

public record CartItemDto(UUID id,
                          ProductDto product,
                          int quantity) {
}
