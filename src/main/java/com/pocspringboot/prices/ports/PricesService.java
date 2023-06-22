package com.pocspringboot.prices.ports;

import com.pocspringboot.prices.domain.model.Prices;
import com.pocspringboot.prices.domain.model.PricesSearch;

public interface PricesService {

    Prices findPrice(PricesSearch prices);

}
