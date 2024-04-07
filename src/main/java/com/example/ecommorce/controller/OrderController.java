package com.example.ecommorce.controller;

import com.example.ecommorce.dto.OrderDto;
import com.example.ecommorce.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/{customerId}")
    public ResponseEntity<OrderDto> createOrder(@PathVariable UUID customerId) {
        OrderDto createdOrderDto = orderService.placeOrder(customerId);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrderDto);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<OrderDto>> getAllOrdersForCustomer(@PathVariable UUID customerId) {
        List<OrderDto> orders = orderService.getOrderForCustomer(customerId);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> getOrderForOrderNumber(@PathVariable UUID orderId) {
        OrderDto orderDto = orderService.getOrderForCode(orderId);
        return ResponseEntity.ok(orderDto);
    }

    @GetMapping("/product/{productId}/price")
    public ResponseEntity<BigDecimal> getCurrentAndHistoricalPricesForProduct(@PathVariable UUID productId) {
        BigDecimal prices = orderService.getCurrentAndHistoricalPricesForProduct(productId);
        return ResponseEntity.ok(prices);
    }
}
