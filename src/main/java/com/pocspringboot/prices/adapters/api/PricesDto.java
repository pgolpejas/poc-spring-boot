package com.pocspringboot.prices.adapters.api;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PricesDto(Integer brandId,
                        LocalDateTime startDate,
                        LocalDateTime endDate,
                        Integer priceListId,
                        Integer productId,
                        BigDecimal price) {

}



