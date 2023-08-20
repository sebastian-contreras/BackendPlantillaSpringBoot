package com.SebastianContreras.SpringBootRest.persistence;

import com.SebastianContreras.SpringBootRest.entities.Maker;

import java.util.List;
import java.util.Optional;

public interface IMakerDao {
    List<Maker> findAll();
    Optional<Maker> findById(Long id);
    void save(Maker maker);
    void deleteById(Long id);

}
