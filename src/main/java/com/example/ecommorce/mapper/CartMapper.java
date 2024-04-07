package com.example.ecommorce.mapper;


import com.example.ecommorce.dto.CartDto;
import com.example.ecommorce.model.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CartMapper {
    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);

    CartDto cartToCartDTO(Cart cart);

    Cart cartDTOToCart(CartDto cartDTO);

}
