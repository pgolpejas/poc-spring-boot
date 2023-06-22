package com.pocspringboot.prices.ports;

import com.pocspringboot.prices.domain.model.Prices;
import com.pocspringboot.prices.domain.model.PricesSearch;

import java.util.List;

public interface PricesRepository {

    List<Prices> findAll();

    List<Prices> findPrice(PricesSearch prices);

}
