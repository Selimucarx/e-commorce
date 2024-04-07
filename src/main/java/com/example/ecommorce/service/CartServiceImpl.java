package com.example.ecommorce.service;

import com.example.ecommorce.dto.CartDto;
import com.example.ecommorce.exception.CustomerNotFoundException;
import com.example.ecommorce.exception.ProductNotFoundException;
import com.example.ecommorce.mapper.CartMapper;
import com.example.ecommorce.model.*;
import com.example.ecommorce.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final CartMapper cartMapper;
    private final CustomerRepository customerRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository, CartMapper cartMapper,
                           CustomerRepository customerRepository, CartItemRepository cartItemRepository,
                           ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.cartMapper = cartMapper;
        this.customerRepository = customerRepository;
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
    }

    @Override
    public CartDto addProductToCart(UUID customerId, UUID productId, Map<String, Integer> request) {
        Customer customer = getCustomerById(customerId);
        Cart cart = customer.getCart();
        int requestedQuantity = request.get("quantity");

        updateCartItemQuantity(cart, productId, requestedQuantity);
        updateTotalPrice(cart);

        return cartMapper.cartToCartDTO(cart);
    }

    @Override
    public CartDto getCartByCustomerId(UUID customerId) {
        Customer customer = getCustomerById(customerId);
        Cart cart = customer.getCart();
        updateTotalPrice(cart);
        return cartMapper.cartToCartDTO(cart);
    }


    @Override
    @Transactional
    public void removeAllItemsFromCart(UUID customerId) {
        Customer customer = getCustomerById(customerId);
        Cart cart = customer.getCart();
        cart.getCartItems().clear();
        updateTotalPrice(cart);
        cartRepository.save(cart);
    }

    @Override
    @Transactional
    public void removeProductFromCart(UUID customerId, UUID productId) {
        Customer customer = getCustomerById(customerId);
        Cart cart = customer.getCart();
        cart.getCartItems().removeIf(cartItem -> cartItem.getProduct().getId().equals(productId));
        updateTotalPrice(cart);
        cartRepository.save(cart);
    }

    @Override
    @Transactional
    public CartDto updateCart(UUID customerId, UUID productId, Map<String, Integer> request) {
        Customer customer = getCustomerById(customerId);
        Cart cart = customer.getCart();
        int requestedQuantity = request.get("quantity");

        updateCartItemQuantity(cart, productId, requestedQuantity);

        updateTotalPrice(cart);
        cartRepository.save(cart);
        return cartMapper.cartToCartDTO(cart);
    }


    private Customer getCustomerById(UUID customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(ErrorMessageType.CUSTOMER_NOT_FOUND));
    }

    private Product getProductById(UUID productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(ErrorMessageType.PRODUCT_NOT_FOUND));
    }

    private CartItem createCartItem(Product product, int quantity, Cart cart) {
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        cartItem.setCart(cart);
        return cartItem;
    }

    private void updateTotalPrice(Cart cart) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (CartItem cartItem : cart.getCartItems()) {
            BigDecimal itemPrice = cartItem.getProduct().getPrice().multiply(BigDecimal.valueOf(cartItem.getQuantity()));
            totalPrice = totalPrice.add(itemPrice);
        }
        cart.setTotalPrice(totalPrice);
        cartRepository.save(cart);
    }

    private void updateCartItemQuantity(Cart cart, UUID productId, int requestedQuantity) {
        for (CartItem cartItem : cart.getCartItems()) {
            if (cartItem.getProduct().getId().equals(productId)) {
                int newQuantity = cartItem.getQuantity() + requestedQuantity;
                cartItem.setQuantity(newQuantity);
                return;
            }
        }

        Product product = getProductById(productId);
        CartItem cartItem = createCartItem(product, requestedQuantity, cart);
        cartItemRepository.save(cartItem);
        cart.getCartItems().add(cartItem);
    }

}