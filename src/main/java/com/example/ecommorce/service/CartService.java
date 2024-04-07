package com.example.ecommorce.service;

import com.example.ecommorce.dto.CartDto;


import java.util.Map;
import java.util.UUID;

public interface CartService {
    CartDto getCartByCustomerId(UUID customerId);

    CartDto addProductToCart(UUID customerId, UUID productId, Map<String, Integer> request);


    CartDto updateCart(UUID customerId, UUID productId, Map<String, Integer> request);

    void removeProductFromCart(UUID customerId, UUID productId);

    void removeAllItemsFromCart(UUID customerId);

}