package com.example.ecommorce.service;


import com.example.ecommorce.dto.ProductDto;
import com.example.ecommorce.mapper.ProductMapper;
import com.example.ecommorce.model.Product;
import com.example.ecommorce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductMapper productMapper, ProductRepository productRepository) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        Product savedProduct = productRepository.save(product);
        return productMapper.toDto(savedProduct);
    }

    @Override
    public List<ProductDto> getProduct() {
        return productRepository.findAll().stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }



    @Override
    public ProductDto deleteProduct(UUID productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Bu id ile bir ürün bulunamadı!" + productId));
        productRepository.deleteById(productId);
        return productMapper.toDto(product);
    }


    // TODO: Product Guncelleme islemleri sonradan eklenecek.

}
