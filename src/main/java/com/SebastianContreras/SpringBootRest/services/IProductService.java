package com.SebastianContreras.SpringBootRest.services;

import com.SebastianContreras.SpringBootRest.entities.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IProductService {

    List<Product> findAll();
    Optional<Product> findById(Long id);
    List<Product> findByPriceInRange(BigDecimal min, BigDecimal max);
    void save(Product product);
    void deleteById(Long id);
}
