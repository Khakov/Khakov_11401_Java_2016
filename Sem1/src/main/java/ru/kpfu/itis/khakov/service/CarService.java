package ru.kpfu.itis.khakov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.khakov.entity.Car;
import ru.kpfu.itis.khakov.entity.CarManufacture;
import ru.kpfu.itis.khakov.entity.Model;
import ru.kpfu.itis.khakov.repository.CarRepository;

import java.util.List;

/**
 * Created by Rus on 20.04.2016.
 */
@Service
public class CarService {
    @Autowired
    public CarRepository carRepository;

    @Transactional
    public List<Car> getAllCar() {
        return carRepository.findAll();
    }

    @Transactional
    public Car getById(Long id) {
        return carRepository.findById(id);
    }

    @Transactional
    public Car editCar(Car car, CarManufacture manufacture, Model carModel, Integer price, double kof) {
        car.setManufacture(manufacture);
        car.setModel(carModel);
        car.setPrice(price);
        car.setKof(kof);
        return carRepository.saveAndFlush(car);
    }

    @Transactional
    public Car addCar(Car car) {
        return carRepository.saveAndFlush(car);
    }

    @Transactional
    public void deleteCar(Long id) {
        Car car = carRepository.findById(id);
        carRepository.delete(car);
    }
}
