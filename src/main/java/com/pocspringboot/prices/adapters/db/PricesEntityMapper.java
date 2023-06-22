package com.pocspringboot.prices.adapters.db;

import com.pocspringboot.prices.domain.model.Prices;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PricesEntityMapper {

    PricesEntity toPricesEntity(Prices search);

    Prices toPrices(PricesEntity entity);

}
