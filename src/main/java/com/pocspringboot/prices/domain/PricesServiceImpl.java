package com.pocspringboot.prices.domain;

import com.pocspringboot.prices.domain.model.Prices;
import com.pocspringboot.prices.domain.model.PricesSearch;
import com.pocspringboot.prices.ports.PricesRepository;
import com.pocspringboot.prices.ports.PricesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
class PricesServiceImpl implements PricesService {

    private final PricesRepository pricesRepository;

    @Override
    public Prices findPrice(PricesSearch prices) {

        List<Prices> pricesReturn = pricesRepository.findPrice(prices);
        if (!CollectionUtils.isEmpty(pricesReturn)) {
            return pricesReturn.get(0);
        } else {
            return null;
        }
    }

}
