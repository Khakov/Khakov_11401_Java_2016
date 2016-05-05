package ru.kpfu.itis.khakov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.khakov.entity.Car;
import ru.kpfu.itis.khakov.repository.CarRepository;

import java.util.List;

/**
 * Created by Rus on 20.04.2016.
 */
@Service
public class CarService {
    @Autowired
    CarRepository carRepository;
    @Transactional
    public List<Car> getAllCar() {
        return carRepository.findAll();
    }
    @Transactional
    public Car getById(Long id){
        return carRepository.findById(id);
    }
}
