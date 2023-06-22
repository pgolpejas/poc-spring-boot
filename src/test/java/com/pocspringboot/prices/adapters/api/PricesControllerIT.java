package com.pocspringboot.pricesDto.adapters.api;

import com.pocspringboot.prices.adapters.api.PricesController;
import com.pocspringboot.prices.adapters.api.PricesDto;
import com.pocspringboot.prices.adapters.api.PricesSearchDto;
import com.pocspringboot.utils.RequestUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PricesControllerIT {

    @Autowired
    protected TestRestTemplate restTemplate;

    /**
     * Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (BRAND_1) -> 1 35.50
     */
    @Test
    void findPrice1() throws Exception {
        PricesSearchDto searchDto = new PricesSearchDto(LocalDateTime.of(2020, 6, 14, 10, 0, 0), 35455, 1);

        final ResponseEntity<PricesDto> response =
            restTemplate.exchange(PricesController.MAPPING + PricesController.SEARCH_PATH, HttpMethod.POST,
                RequestUtils.buildRequest(null, searchDto), PricesDto.class);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        PricesDto pricesDto = response.getBody();
        Assertions.assertThat(pricesDto).as("pricesDto").isNotNull();
        Assertions.assertThat(pricesDto.brandId()).as("brandId").isEqualTo(1);
        Assertions.assertThat(pricesDto.productId()).as("productId").isEqualTo(35455);
        Assertions.assertThat(pricesDto.priceListId()).as("priceListId").isEqualTo(1);
        Assertions.assertThat(pricesDto.price()).as("price").isEqualTo(new BigDecimal("35.50"));

    }

    /**
     * Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (BRAND_1) -> 2 25.45
     */
    @Test
    void findPrice2() throws Exception {
        PricesSearchDto searchDto = new PricesSearchDto(LocalDateTime.of(2020, 6, 14, 16, 0, 0), 35455, 1);
        final ResponseEntity<PricesDto> response =
            restTemplate.exchange(PricesController.MAPPING + PricesController.SEARCH_PATH, HttpMethod.POST,
                RequestUtils.buildRequest(null, searchDto), PricesDto.class);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        PricesDto pricesDto = response.getBody();
        Assertions.assertThat(pricesDto.brandId()).as("brandId").isEqualTo(1);
        Assertions.assertThat(pricesDto.productId()).as("productId").isEqualTo(35455);
        Assertions.assertThat(pricesDto.priceListId()).as("priceListId").isEqualTo(2);
        Assertions.assertThat(pricesDto.price()).as("price").isEqualTo(new BigDecimal("25.45"));

    }

    /**
     * Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (BRAND_1) -> 1 35.50
     */
    @Test
    void findPrice3() throws Exception {
        PricesSearchDto searchDto = new PricesSearchDto(LocalDateTime.of(2020, 6, 14, 21, 0, 0), 35455, 1);
        final ResponseEntity<PricesDto> response =
            restTemplate.exchange(PricesController.MAPPING + PricesController.SEARCH_PATH, HttpMethod.POST,
                RequestUtils.buildRequest(null, searchDto), PricesDto.class);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        PricesDto pricesDto = response.getBody();
        Assertions.assertThat(pricesDto.brandId()).as("brandId").isEqualTo(1);
        Assertions.assertThat(pricesDto.productId()).as("productId").isEqualTo(35455);
        Assertions.assertThat(pricesDto.priceListId()).as("priceListId").isEqualTo(1);
        Assertions.assertThat(pricesDto.price()).as("price").isEqualTo(new BigDecimal("35.50"));

    }

    /**
     * Test 3: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (BRAND_1) -> 3 30.50 2 REG
     */
    @Test
    void findPrice4() throws Exception {
        PricesSearchDto searchDto = new PricesSearchDto(LocalDateTime.of(2020, 6, 15, 10, 0, 0), 35455, 1);
        final ResponseEntity<PricesDto> response =
            restTemplate.exchange(PricesController.MAPPING + PricesController.SEARCH_PATH, HttpMethod.POST,
                RequestUtils.buildRequest(null, searchDto), PricesDto.class);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        PricesDto pricesDto = response.getBody();
        Assertions.assertThat(pricesDto.brandId()).as("brandId").isEqualTo(1);
        Assertions.assertThat(pricesDto.productId()).as("productId").isEqualTo(35455);
        Assertions.assertThat(pricesDto.priceListId()).as("priceListId").isEqualTo(3);
        Assertions.assertThat(pricesDto.price()).as("price").isEqualTo(new BigDecimal("30.50"));

    }

    /**
     * Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (BRAND_1) -> 4 38.95 2 REG
     */
    @Test
    void findPrice5() throws Exception {
        PricesSearchDto searchDto = new PricesSearchDto(LocalDateTime.of(2020, 6, 16, 21, 0, 0), 35455, 1);
        final ResponseEntity<PricesDto> response =
            restTemplate.exchange(PricesController.MAPPING + PricesController.SEARCH_PATH, HttpMethod.POST,
                RequestUtils.buildRequest(null, searchDto), PricesDto.class);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        PricesDto pricesDto = response.getBody();
        Assertions.assertThat(pricesDto.brandId()).as("brandId").isEqualTo(1);
        Assertions.assertThat(pricesDto.productId()).as("productId").isEqualTo(35455);
        Assertions.assertThat(pricesDto.priceListId()).as("priceListId").isEqualTo(4);
        Assertions.assertThat(pricesDto.price()).as("price").isEqualTo(new BigDecimal("38.95"));
    }


    /**
     * Test 10: petición a las 10:00 del día 14 del producto 35455   para la brand 2 (BRAND_1) -> NOT FOUND
     */
    @Test
    void findPriceByBrandErrorNotFound() throws Exception {
        PricesSearchDto searchDto = new PricesSearchDto(LocalDateTime.of(2020, 6, 14, 10, 0, 0), 35455, 2);
        final ResponseEntity<PricesDto> response =
            restTemplate.exchange(PricesController.MAPPING + PricesController.SEARCH_PATH, HttpMethod.POST,
                RequestUtils.buildRequest(null, searchDto), PricesDto.class);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);

    }

    /**
     * Test 11: petición a las 10:00 del día 14 del producto 45455   para la brand 1 (BRAND_1) -> NOT FOUND
     */
    @Test
    void findPriceByProductErrorNotFound() throws Exception {
        PricesSearchDto searchDto = new PricesSearchDto(LocalDateTime.of(2020, 6, 14, 10, 0, 0), 45455, 1);
        final ResponseEntity<PricesDto> response =
            restTemplate.exchange(PricesController.MAPPING + PricesController.SEARCH_PATH, HttpMethod.POST,
                RequestUtils.buildRequest(null, searchDto), PricesDto.class);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);

    }

    /**
     * Test 12: petición a las 10:00 del día 14 de 2023 del producto 35455   para la brand 1 (BRAND_1) -> NOT FOUND
     */
    @Test
    void findPriceByDateOutOfRangeNotFound() throws Exception {
        PricesSearchDto searchDto = new PricesSearchDto(LocalDateTime.of(2023, 6, 14, 10, 0, 0), 45455, 1);
        final ResponseEntity<PricesDto> response =
            restTemplate.exchange(PricesController.MAPPING + PricesController.SEARCH_PATH, HttpMethod.POST,
                RequestUtils.buildRequest(null, searchDto), PricesDto.class);


        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void findPriceWithSearchDateNull() throws Exception {
        PricesSearchDto searchDto = new PricesSearchDto(null, 3455, 1);
        final ResponseEntity<PricesDto> response =
            restTemplate.exchange(PricesController.MAPPING + PricesController.SEARCH_PATH, HttpMethod.POST,
                RequestUtils.buildRequest(null, searchDto), PricesDto.class);


        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void findPriceWithBrandNull() throws Exception {
        PricesSearchDto searchDto = new PricesSearchDto(LocalDateTime.of(2023, 6, 14, 10, 0, 0), 3455, null);
        final ResponseEntity<PricesDto> response =
            restTemplate.exchange(PricesController.MAPPING + PricesController.SEARCH_PATH, HttpMethod.POST,
                RequestUtils.buildRequest(null, searchDto), PricesDto.class);


        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void findPriceWithProductNull() throws Exception {
        PricesSearchDto searchDto = new PricesSearchDto(LocalDateTime.of(2023, 6, 14, 10, 0, 0), null, 1);
        final ResponseEntity<PricesDto> response =
            restTemplate.exchange(PricesController.MAPPING + PricesController.SEARCH_PATH, HttpMethod.POST,
                RequestUtils.buildRequest(null, searchDto), PricesDto.class);


        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }



}