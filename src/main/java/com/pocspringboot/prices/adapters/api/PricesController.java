package com.pocspringboot.prices.adapters.api;

import com.pocspringboot.prices.domain.model.Prices;
import com.pocspringboot.prices.ports.PricesService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Prices controller", description = "Prices API")
@RequestMapping(value = PricesController.MAPPING)
@RequiredArgsConstructor
public class PricesController {

    public static final String DELIMITER_PATH = "/";
    public static final String MAPPING = DELIMITER_PATH + "prices/1.0";
    public static final String SEARCH_PATH = DELIMITER_PATH + "search";

    private final PricesService service;
    private final PricesSearchDtoMapper pricesSearchDtoMapper;
    private final PricesDtoMapper pricesDtoMapper;

    @PostMapping(value = SEARCH_PATH)
    public ResponseEntity<PricesDto> search(@Valid @RequestBody PricesSearchDto searchDto) {
        Prices search = service.findPrice(pricesSearchDtoMapper.toPricesSearch(searchDto));

        if (null != search) {
            return ResponseEntity.ok(pricesDtoMapper.toPricesDto(search));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
