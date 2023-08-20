package com.SebastianContreras.SpringBootRest.repositories;

import com.SebastianContreras.SpringBootRest.entities.Maker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakerRepository extends CrudRepository<Maker,Long> {
}
