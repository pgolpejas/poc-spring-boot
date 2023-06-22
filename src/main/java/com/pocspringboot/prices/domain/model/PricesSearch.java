package com.pocspringboot.prices.domain.model;

import java.time.LocalDateTime;

public record PricesSearch(

    LocalDateTime searchDate,

    Integer productId,

    Integer brandId) {

}

