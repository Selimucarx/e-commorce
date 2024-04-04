package com.example.ecommorce.mapper;

import com.example.ecommorce.dto.ProductDto;
import com.example.ecommorce.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product toEntity(ProductDto dto);

    ProductDto toDto(Product entity);
}
