package com.pocspringboot.prices.adapters.api;

import com.pocspringboot.prices.domain.model.PricesSearch;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface PricesSearchDtoMapper {

    PricesSearchDto toPricesSearchDto(PricesSearch search);

    PricesSearch toPricesSearch(PricesSearchDto searchDto);

}
