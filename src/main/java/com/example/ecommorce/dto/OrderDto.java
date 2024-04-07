package com.example.ecommorce.dto;

import com.example.ecommorce.model.OrderItem;

import java.util.List;

public record  OrderDto(List<OrderItem> orderItems ) {
}
