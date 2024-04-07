package com.example.ecommorce.service;

import com.example.ecommorce.dto.OrderDto;
import com.example.ecommorce.exception.CustomerCartNotFoundException;
import com.example.ecommorce.exception.CustomerNotFoundException;
import com.example.ecommorce.exception.InsufficientStockException;
import com.example.ecommorce.exception.OrderNotFoundException;
import com.example.ecommorce.mapper.OrderMapper;
import com.example.ecommorce.model.*;
import com.example.ecommorce.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    private final CustomerRepository customerRepository;

    private final PriceHistoryRepository priceHistoryRepository;
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper, CustomerRepository customerRepository, PriceHistoryRepository priceHistoryRepository, ProductRepository productRepository, CartRepository cartRepository) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.customerRepository = customerRepository;
        this.priceHistoryRepository = priceHistoryRepository;
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public OrderDto placeOrder(UUID customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(ErrorMessageType.CUSTOMER_NOT_FOUND));

        Cart cart = customer.getCart();
        if (cart == null || cart.getCartItems().isEmpty()) {
            throw new CustomerCartNotFoundException(ErrorMessageType.CUSTOMER_CART_NOT_FOUND);
        }
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem cartItem : cartItems) {
            Product product = cartItem.getProduct();
            int quantity = cartItem.getQuantity();
            int availableStock = product.getStock();

            if (quantity > availableStock) {
                throw new InsufficientStockException(ErrorMessageType.INSUFFICIENT_STOCK);
            }
        }

        Order order = new Order();
        order.setCustomer(customer);

        for (CartItem cartItem : cartItems) {
            Product product = cartItem.getProduct();
            int quantity = cartItem.getQuantity();

            product.setStock(product.getStock() - quantity);
            productRepository.save(product);

            BigDecimal currentProductPrice = product.getPrice();

            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setQuantity(quantity);
            orderItem.setPrice(currentProductPrice);

            order.addOrderItem(orderItem);
        }

        BigDecimal totalPrice = calculateTotalPrice(order);
        order.setTotalPrice(totalPrice);

        cart.getCartItems().clear();
        cartRepository.save(cart);

        orderRepository.save(order);
        return orderMapper.toDto(order);
    }




    @Override
    public List<OrderDto> getOrderForCustomer(UUID customerId) {
        List<Order> orders = orderRepository.findByCustomer_Id(customerId);
        return orders.stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto getOrderForCode(UUID orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            return orderMapper.toDto(order);
        } else {
            throw new OrderNotFoundException(ErrorMessageType.ORDER_NOT_FOUND);
        }
    }

    @Override
    public BigDecimal getCurrentAndHistoricalPricesForProduct(UUID productId) {
        List<BigDecimal> historicalPrices = priceHistoryRepository.findByProductId(productId)
                .stream()
                .map(PriceHistory::getPrice)
                .collect(Collectors.toList());

        BigDecimal currentPrice = productRepository.findById(productId)
                .map(Product::getPrice)
                .orElse(null);


        return null;
    }


    private BigDecimal calculateTotalPrice(Order order) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (OrderItem orderItem : order.getOrderItems()) {
            BigDecimal itemPrice = orderItem.getProduct().getPrice().multiply(BigDecimal.valueOf(orderItem.getQuantity()));
            totalPrice = totalPrice.add(itemPrice);
        }
        return totalPrice;
    }


}