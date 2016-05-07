package ru.kpfu.itis.khakov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.khakov.entity.CarManufacture;
import ru.kpfu.itis.khakov.repository.ManufactureRepository;

import java.util.List;

/**
 * Created by Rus on 20.04.2016.
 */
@Service
public class ManufactureService {
    @Autowired
    public ManufactureRepository manufactureRepository;
    @Transactional
    public List<CarManufacture>  getAll(){
        return manufactureRepository.findAll();
    }
    @Transactional
    public CarManufacture getById(Long id) {
        return manufactureRepository.findById(id);
    }
}
