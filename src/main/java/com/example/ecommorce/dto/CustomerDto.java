package com.example.ecommorce.dto;

import java.util.Date;
import java.util.UUID;

public record CustomerDto(UUID id,
                          Date createDate,
                          String email,
                          String password,
                          UUID cartId) {
}
