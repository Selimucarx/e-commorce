package com.example.ecommorce.mapper;

import com.example.ecommorce.dto.CustomerDto;
import com.example.ecommorce.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer toEntity(CustomerDto dto);

    CustomerDto toDto(Customer entity);
}
