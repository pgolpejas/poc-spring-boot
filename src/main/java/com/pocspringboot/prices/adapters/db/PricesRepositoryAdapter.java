package com.pocspringboot.prices.adapters.db;

import com.pocspringboot.prices.domain.model.Prices;
import com.pocspringboot.prices.domain.model.PricesSearch;
import com.pocspringboot.prices.ports.PricesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
class PricesRepositoryAdapter implements PricesRepository {
    private final JpaPricesRepository jpaPricesRepository;
    private final PricesEntityMapper pricesEntityMapper;

    @Override
    public List<Prices> findAll(){
        return jpaPricesRepository.findAll().stream()
            .map(pricesEntityMapper::toPrices)
            .toList();
    }

    @Override
    public List<Prices> findPrice(PricesSearch prices) {
        return jpaPricesRepository.findByEndDateGreaterThanEqualAndStartDateLessThanEqualAndProductIdAndBrandIdOrderByPriorityDesc(
                prices.searchDate(), prices.searchDate(), prices.productId(), prices.brandId())
            .stream()
            .map(pricesEntityMapper::toPrices)
            .toList();
    }


}
