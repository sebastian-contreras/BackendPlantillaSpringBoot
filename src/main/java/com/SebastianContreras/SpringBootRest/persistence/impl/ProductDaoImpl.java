package com.SebastianContreras.SpringBootRest.persistence.impl;

import com.SebastianContreras.SpringBootRest.entities.Product;
import com.SebastianContreras.SpringBootRest.persistence.IProductDao;
import com.SebastianContreras.SpringBootRest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
@Component
public class ProductDaoImpl implements IProductDao {
    @Autowired
    private ProductRepository repository;
    @Override
    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Product> findByPriceInRange(BigDecimal min, BigDecimal max) {

        return repository.findProductByPriceBetween(min,max);
    }

    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
