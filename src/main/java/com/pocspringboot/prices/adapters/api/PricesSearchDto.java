package com.pocspringboot.prices.adapters.api;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record PricesSearchDto(

    @NotNull
    LocalDateTime searchDate,

    @NotNull
    @Positive
    @Schema(example = "35455")
    Integer productId,

    @NotNull
    @Positive
    @Schema(example = "1")
    Integer brandId) {


}

