package com.pocspringboot.prices.adapters.api;

import com.pocspringboot.prices.domain.model.Prices;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface PricesDtoMapper {

    PricesDto toPricesDto(Prices search);

    Prices toPrices(PricesDto searchDto);

}
