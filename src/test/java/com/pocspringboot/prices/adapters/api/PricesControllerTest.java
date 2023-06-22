package com.pocspringboot.prices.adapters.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pocspringboot.prices.domain.model.Prices;
import com.pocspringboot.prices.ports.PricesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PricesController.class)
class PricesControllerTest {

    @MockBean
    private PricesService service;

    @MockBean
    private PricesSearchDtoMapper pricesSearchDtoMapper;

    @MockBean
    private PricesDtoMapper pricesDtoMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mvc;

    @Test
    void search() throws Exception {
        PricesSearchDto searchDto = new PricesSearchDto(LocalDateTime.of(2020, 6, 14, 10, 0, 0), 35455, 1);
        Prices prices =
            new Prices(1, 1, LocalDateTime.now(), LocalDateTime.now(), 1, 1, (short) 1, new BigDecimal("24.50"), Prices.CurrencyEnum.EUR);

        when(service.findPrice(pricesSearchDtoMapper.toPricesSearch(searchDto))).thenReturn(prices);

        mvc.perform(MockMvcRequestBuilders.post(PricesController.MAPPING + PricesController.SEARCH_PATH)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(searchDto))).andExpect(status().isOk()).andDo(print()).andReturn();

    }

    @Test
    void searchValidationProductIdNull() throws Exception {
        PricesSearchDto searchDto = new PricesSearchDto(LocalDateTime.of(2020, 6, 14, 10, 0, 0), null, 1);
        Prices prices =
            new Prices(1, 1, LocalDateTime.now(), LocalDateTime.now(), 1, 1, (short) 1, new BigDecimal("24.50"), Prices.CurrencyEnum.EUR);


        when(service.findPrice(pricesSearchDtoMapper.toPricesSearch(searchDto))).thenReturn(prices);

        mvc.perform(MockMvcRequestBuilders.post(PricesController.MAPPING + PricesController.SEARCH_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(searchDto)))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.errors").isArray())
            .andExpect(jsonPath("$.errors", hasSize(1)))
            .andExpect(jsonPath("$.errors[0].field").value("productId"))
            .andExpect(jsonPath("$.errors[0].code").value("NotNull"))
            .andExpect(jsonPath("$.errors[0].defaultMessage").value("must not be null"))
            .andDo(print())
            .andReturn();

    }

    @Test
    void searchValidationBrandIdNull() throws Exception {
        PricesSearchDto searchDto = new PricesSearchDto(LocalDateTime.of(2020, 6, 14, 10, 0, 0), 35455, null);
        Prices prices =
            new Prices(1, 1, LocalDateTime.now(), LocalDateTime.now(), 1, 1, (short) 1, new BigDecimal("24.50"), Prices.CurrencyEnum.EUR);


        when(service.findPrice(pricesSearchDtoMapper.toPricesSearch(searchDto))).thenReturn(prices);

        mvc.perform(MockMvcRequestBuilders.post(PricesController.MAPPING + PricesController.SEARCH_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(searchDto)))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.errors").isArray())
            .andExpect(jsonPath("$.errors", hasSize(1)))
            .andExpect(jsonPath("$.errors[0].field").value("brandId"))
            .andExpect(jsonPath("$.errors[0].code").value("NotNull"))
            .andExpect(jsonPath("$.errors[0].defaultMessage").value("must not be null"))
            .andDo(print())
            .andReturn();

    }

    @Test
    void searchValidationSearchDatedNull() throws Exception {
        PricesSearchDto searchDto = new PricesSearchDto(null, 35455, 1);
        Prices prices =
            new Prices(1, 1, LocalDateTime.now(), LocalDateTime.now(), 1, 1, (short) 1, new BigDecimal("24.50"), Prices.CurrencyEnum.EUR);


        when(service.findPrice(pricesSearchDtoMapper.toPricesSearch(searchDto))).thenReturn(prices);

        mvc.perform(MockMvcRequestBuilders.post(PricesController.MAPPING + PricesController.SEARCH_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(searchDto)))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.errors").isArray())
            .andExpect(jsonPath("$.errors", hasSize(1)))
            .andExpect(jsonPath("$.errors[0].field").value("searchDate"))
            .andExpect(jsonPath("$.errors[0].code").value("NotNull"))
            .andExpect(jsonPath("$.errors[0].defaultMessage").value("must not be null"))
            .andDo(print())
            .andReturn();

    }

}