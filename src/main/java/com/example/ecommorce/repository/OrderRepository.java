package com.example.ecommorce.repository;

import com.example.ecommorce.model.Order;
import com.example.ecommorce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
    List<Order> findByCustomer_Id(UUID customerId);
    Optional<Order> findById(UUID orderId);
}
