package com.pocspringboot.prices.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Prices(Integer id,
                     Integer brandId,
                     LocalDateTime startDate,
                     LocalDateTime endDate,
                     Integer priceListId,
                     Integer productId,
                     Short priority,
                     BigDecimal price,
                     CurrencyEnum curr) {
    public enum CurrencyEnum {
        EUR,
        USD
    }

    @Override
    public String toString() {
        return "Prices{" + "id=" + id + ", brandId=" + brandId + ", startDate=" + startDate + ", endDate=" + endDate + ", priceListId="
            + priceListId + ", productId=" + productId + ", priority=" + priority + ", price=" + price + ", curr=" + curr + '}';
    }
}



