package com.example.ecommorce.service;

import com.example.ecommorce.dto.ProductDto;
import com.example.ecommorce.exception.ProductNotFoundException;
import com.example.ecommorce.mapper.ProductMapper;
import com.example.ecommorce.model.ErrorMessageType;
import com.example.ecommorce.model.PriceHistory;
import com.example.ecommorce.model.Product;
import com.example.ecommorce.repository.PriceHistoryRepository;
import com.example.ecommorce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    private final PriceHistoryRepository priceHistoryRepository;

    public ProductServiceImpl(ProductMapper productMapper, ProductRepository productRepository,
                              PriceHistoryRepository priceHistoryRepository) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
        this.priceHistoryRepository = priceHistoryRepository;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        return productMapper.toDto(productRepository.save(product));
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto deleteProduct(UUID productId) {
        Product product = getProductById(productId);
        productRepository.deleteById(productId);
        return productMapper.toDto(product);
    }

    public ProductDto updateProduct(UUID productId, ProductDto productDto) {
        Product existingProduct = getProductById(productId);
        BigDecimal previousPrice = existingProduct.getPrice();

        existingProduct.setPrice(productDto.price());
        existingProduct.setStock(productDto.stock());


        Product savedProduct = productRepository.save(existingProduct);

        savePriceHistory(existingProduct, productDto.price(), previousPrice);

        return productMapper.toDto(savedProduct);
    }


    private Product getProductById(UUID productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(ErrorMessageType.PRODUCT_NOT_FOUND));
    }


    private void savePriceHistory(Product product, BigDecimal currentPrice, BigDecimal previousPrice) {
        PriceHistory priceHistory = new PriceHistory();
        priceHistory.setProduct(product);
        priceHistory.setPrice(currentPrice);
        priceHistory.setOrderItemPrice(previousPrice);
        priceHistoryRepository.save(priceHistory);
    }
}