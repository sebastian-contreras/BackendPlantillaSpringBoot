package com.SebastianContreras.SpringBootRest.repositories;

import com.SebastianContreras.SpringBootRest.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {

}
