package com.example.ecommorce.mapper;

import com.example.ecommorce.dto.OrderItemDto;
import com.example.ecommorce.model.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderItemMapper {
    OrderItemMapper INSTANCE = Mappers.getMapper(OrderItemMapper.class);

    OrderItemDto orderItemToOrderItemDto(OrderItem orderItem);
}