package com.pocspringboot.prices.adapters.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "product", indexes = {
    @Index(name = "product_name_uk", columnList = "name", unique = true),
    @Index(name = "product_code_uk", columnList = "code", unique = true)
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "code")
@SuppressWarnings("squid:S1170")
class ProductEntity {

    @Id
    @Column(name = "code", length = 50, nullable = false)
    private Integer code;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "description", length = 100)
    private String description;

    @OneToMany(mappedBy = "product")
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private final List<PricesEntity> prices = null;
}

