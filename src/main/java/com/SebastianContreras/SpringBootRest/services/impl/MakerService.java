package com.SebastianContreras.SpringBootRest.services.impl;

import com.SebastianContreras.SpringBootRest.entities.Maker;
import com.SebastianContreras.SpringBootRest.persistence.IMakerDao;
import com.SebastianContreras.SpringBootRest.services.IMakerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MakerService implements IMakerService {
    @Autowired
    private IMakerDao makerDao;

    @Override
    public List<Maker> findAll() {
        return makerDao.findAll();
    }

    @Override
    public Optional<Maker> findById(Long id) {
        return makerDao.findById(id);
    }

    @Override
    public void save(Maker maker) {
        makerDao.save(maker);
    }

    @Override
    public void deleteById(Long id) {
        makerDao.deleteById(id);
    }
}
