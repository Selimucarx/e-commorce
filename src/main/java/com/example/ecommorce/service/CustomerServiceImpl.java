package com.example.ecommorce.service;

import com.example.ecommorce.dto.CustomerDto;
import com.example.ecommorce.mapper.CustomerMapper;
import com.example.ecommorce.model.Cart;
import com.example.ecommorce.repository.CustomerRepository;
import com.example.ecommorce.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerMapper customerMapper;

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerMapper customerMapper, CustomerRepository customerRepository) {
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto addCustomer(CustomerDto customerDto) {
        Customer customer = customerMapper.toEntity(customerDto);
        Cart cart = new Cart();
        customer.setCart(cart);
        customer = customerRepository.save(customer);
        customer.setCartId(cart.getId());
        cart.setCustomer(customer);
        customerRepository.save(customer);
        return customerMapper.toDto(customer);
    }


}