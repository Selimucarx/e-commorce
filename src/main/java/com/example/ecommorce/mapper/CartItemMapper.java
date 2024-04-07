package com.example.ecommorce.mapper;

import com.example.ecommorce.dto.CartItemDto;
import com.example.ecommorce.model.CartItem;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface CartItemMapper {
    CartItemMapper INSTANCE = Mappers.getMapper(CartItemMapper.class);

    CartItemDto cartItemToCartItemDto(CartItem cartItem);
}
