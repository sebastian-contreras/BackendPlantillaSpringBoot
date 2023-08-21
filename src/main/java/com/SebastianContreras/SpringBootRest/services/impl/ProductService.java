package com.SebastianContreras.SpringBootRest.services.impl;

import com.SebastianContreras.SpringBootRest.entities.Product;
import com.SebastianContreras.SpringBootRest.persistence.IProductDao;
import com.SebastianContreras.SpringBootRest.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class ProductService implements IProductService {
    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productDao.findById(id);
    }

    @Override
    public List<Product> findByPriceInRange(BigDecimal min, BigDecimal max) {
        return productDao.findByPriceInRange(min, max);
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productDao.deleteById(id);
    }
}
