package com.example.ecommorce.mapper;

import com.example.ecommorce.dto.PriceHistoryDto;
import com.example.ecommorce.model.PriceHistory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PriceHistoryMapper {
    PriceHistoryMapper INSTANCE = Mappers.getMapper(PriceHistoryMapper.class);

    PriceHistoryDto priceHistoryToPriceHistoryDto(PriceHistory priceHistory);
}