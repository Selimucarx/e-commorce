package com.example.ecommorce.service;

import com.example.ecommorce.dto.ProductDto;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);
    List<ProductDto> getProduct();
    ProductDto deleteProduct(UUID productId);
 //   ProductDto updateProduct(UUID productId, ProductDto productDto);

    // GUNCELLEME KODU EN SON YAPILACAK
}