package com.example.ecommorce.controller;

import com.example.ecommorce.dto.CartDto;
import com.example.ecommorce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/carts")
public class CartController {
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/{customerId}/addItem/{productId}")
    public ResponseEntity<CartDto> addItemToCart(@PathVariable UUID customerId, @PathVariable UUID productId, @RequestBody Map<String, Integer> request) {
        CartDto cartDto = cartService.addProductToCart(customerId, productId, request);
        return ResponseEntity.ok(cartDto);
    }


    @GetMapping("/{customerId}")
    public ResponseEntity<CartDto> getCartByCustomerId(@PathVariable UUID customerId) {
        CartDto cartDto = cartService.getCartByCustomerId(customerId);
        return ResponseEntity.ok(cartDto);
    }

    @DeleteMapping("/{customerId}/clearCart")
    public ResponseEntity<String> clearCart(@PathVariable UUID customerId) {
        cartService.removeAllItemsFromCart(customerId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{customerId}/removeItem/{productId}")
    public ResponseEntity<String> removeItemFromCart(@PathVariable UUID customerId, @PathVariable UUID productId) {
        cartService.removeProductFromCart(customerId, productId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{customerId}/updateItem/{productId}")
    public ResponseEntity<CartDto> updateCartItem(@PathVariable UUID customerId, @PathVariable UUID productId, @RequestBody Map<String, Integer> request) {
        CartDto updatedCart = cartService.updateCart(customerId, productId, request);
        return ResponseEntity.ok(updatedCart);
    }



}
