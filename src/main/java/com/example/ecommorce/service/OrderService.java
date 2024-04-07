package com.example.ecommorce.service;

import com.example.ecommorce.dto.OrderDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface OrderService {
    OrderDto placeOrder(UUID customerId);

    List<OrderDto> getOrderForCustomer(UUID customerId);

    OrderDto getOrderForCode(UUID orderId);


    BigDecimal getCurrentAndHistoricalPricesForProduct(UUID productId);

}