package com.example.ecommorce.dto;

import com.example.ecommorce.model.CartItem;
import com.example.ecommorce.model.Customer;
import com.example.ecommorce.model.Product;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public record CartDto(UUID id,
                      List<CartItem> cartItems,
                      Customer customer,
                      BigDecimal totalPrice) {
}
