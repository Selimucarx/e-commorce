package com.example.ecommorce.mapper;

import com.example.ecommorce.dto.OrderDto;
import com.example.ecommorce.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order toEntity(OrderDto dto);

    OrderDto toDto(Order entity);
}
