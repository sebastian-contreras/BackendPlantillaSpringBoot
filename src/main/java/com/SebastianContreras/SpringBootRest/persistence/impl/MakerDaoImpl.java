package com.SebastianContreras.SpringBootRest.persistence.impl;

import com.SebastianContreras.SpringBootRest.entities.Maker;
import com.SebastianContreras.SpringBootRest.persistence.IMakerDao;
import com.SebastianContreras.SpringBootRest.repositories.MakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MakerDaoImpl implements IMakerDao {
    @Autowired
    private MakerRepository repository;

    @Override
    public List<Maker> findAll() {
        return (List<Maker>) repository.findAll();
    }

    @Override
    public Optional<Maker> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(Maker maker) {
        repository.save(maker);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
