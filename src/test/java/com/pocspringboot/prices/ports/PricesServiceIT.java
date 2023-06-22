package com.pocspringboot.prices.ports;

import com.pocspringboot.prices.domain.model.Prices;
import com.pocspringboot.prices.domain.model.PricesSearch;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PricesServiceIT {
    @Autowired
    private PricesService pricesService;

    /**
     * Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (BRAND_1) -> 1 35.50
     */
    @Test
    void findPrice1() {
        PricesSearch pricesSearch = new PricesSearch(LocalDateTime.of(2020, 6, 14, 10, 0, 0), 35455, 1);
        Prices prices = pricesService.findPrice(pricesSearch);
        assertNotNull(prices);
        Assertions.assertThat(prices.brandId()).as("brandId").isEqualTo(1);
        Assertions.assertThat(prices.productId()).as("productId").isEqualTo(35455);
        Assertions.assertThat(prices.priceListId()).as("priceListId").isEqualTo(1);
        Assertions.assertThat(prices.price()).as("price").isEqualTo(new BigDecimal("35.50"));
    }

    /**
     * Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (BRAND_1) -> 2 25.45
     */
    @Test
    void findPrice2() {
        PricesSearch pricesSearch = new PricesSearch(LocalDateTime.of(2020, 6, 14, 16, 0, 0), 35455, 1);
        Prices prices = pricesService.findPrice(pricesSearch);
        assertNotNull(prices);
        Assertions.assertThat(prices.brandId()).as("brandId").isEqualTo(1);
        Assertions.assertThat(prices.productId()).as("productId").isEqualTo(35455);
        Assertions.assertThat(prices.priceListId()).as("priceListId").isEqualTo(2);
        Assertions.assertThat(prices.price()).as("price").isEqualTo(new BigDecimal("25.45"));

    }

    /**
     * Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (BRAND_1) -> 1 35.50
     */
    @Test
    void findPrice3() {
        PricesSearch pricesSearch = new PricesSearch(LocalDateTime.of(2020, 6, 14, 21, 0, 0), 35455, 1);
        Prices prices = pricesService.findPrice(pricesSearch);
        assertNotNull(prices);
        Assertions.assertThat(prices.brandId()).as("brandId").isEqualTo(1);
        Assertions.assertThat(prices.productId()).as("productId").isEqualTo(35455);
        Assertions.assertThat(prices.priceListId()).as("priceListId").isEqualTo(1);
        Assertions.assertThat(prices.price()).as("price").isEqualTo(new BigDecimal("35.50"));

    }

    /**
     * Test 3: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (BRAND_1) -> 3 30.50 2 REG
     */
    @Test
    void findPrice4() {
        PricesSearch pricesSearch = new PricesSearch(LocalDateTime.of(2020, 6, 15, 10, 0, 0), 35455, 1);
        Prices prices = pricesService.findPrice(pricesSearch);
        assertNotNull(prices);
        Assertions.assertThat(prices.brandId()).as("brandId").isEqualTo(1);
        Assertions.assertThat(prices.productId()).as("productId").isEqualTo(35455);
        Assertions.assertThat(prices.priceListId()).as("priceListId").isEqualTo(3);
        Assertions.assertThat(prices.price()).as("price").isEqualTo(new BigDecimal("30.50"));

    }

    /**
     * Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (BRAND_1) -> 4 38.95 2 REG
     */
    @Test
    void findPrice5() {
        PricesSearch pricesSearch = new PricesSearch(LocalDateTime.of(2020, 6, 16, 21, 0, 0), 35455, 1);
        Prices prices = pricesService.findPrice(pricesSearch);
        assertNotNull(prices);
        Assertions.assertThat(prices.brandId()).as("brandId").isEqualTo(1);
        Assertions.assertThat(prices.productId()).as("productId").isEqualTo(35455);
        Assertions.assertThat(prices.priceListId()).as("priceListId").isEqualTo(4);
        Assertions.assertThat(prices.price()).as("price").isEqualTo(new BigDecimal("38.95"));
    }


    /**
     * Test 10: petición a las 10:00 del día 14 del producto 35455   para la brand 2 (BRAND_1) -> NOT FOUND
     */
    @Test
    void findPriceByBrandErrorNotFound() {
        PricesSearch pricesSearch = new PricesSearch(LocalDateTime.of(2020, 6, 14, 10, 0, 0), 35455, 2);
        Prices prices = pricesService.findPrice(pricesSearch);

        assertNull(prices);
    }

    /**
     * Test 11: petición a las 10:00 del día 14 del producto 45455   para la brand 1 (BRAND_1) -> NOT FOUND
     */
    @Test
    void findPriceByProductErrorNotFound() {
        PricesSearch pricesSearch = new PricesSearch(LocalDateTime.of(2020, 6, 14, 10, 0, 0), 45455, 1);
        Prices prices = pricesService.findPrice(pricesSearch);

        assertNull(prices);
    }

    /**
     * Test 12: petición a las 10:00 del día 14 de 2023 del producto 35455   para la brand 1 (BRAND_1) -> NOT FOUND
     */
    @Test
    void findPriceByDateOutOfRangeNotFound() {
        PricesSearch pricesSearch = new PricesSearch(LocalDateTime.of(2023, 6, 14, 10, 0, 0), 45455, 1);
        Prices prices = pricesService.findPrice(pricesSearch);

        assertNull(prices);
    }

}