package com.SebastianContreras.SpringBootRest.repositories;

import com.SebastianContreras.SpringBootRest.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {
//Formas de Crear metodos personalizados
//QueryMethods
    List<Product> findProductByPriceBetween(BigDecimal min, BigDecimal max);

//    Segumda Forma
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN ?1 AND ?2")
    List<Product> findProductInRange(BigDecimal min ,BigDecimal max);
}
