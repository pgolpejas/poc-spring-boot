package com.pocspringboot.prices.adapters.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
interface JpaPricesRepository extends JpaRepository<PricesEntity, Integer> {

    List<PricesEntity> findByEndDateGreaterThanEqualAndStartDateLessThanEqualAndProductIdAndBrandIdOrderByPriorityDesc(
        LocalDateTime endDate,
        LocalDateTime startDate,
        Integer productId,
        Integer brandId
    );

}
