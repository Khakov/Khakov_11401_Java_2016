package ru.kpfu.itis.khakov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.khakov.entity.Motor;
import ru.kpfu.itis.khakov.repository.MotorRepository;

/**
 * Created by Rus on 20.04.2016.
 */
@Service
public class MotorService {
    @Autowired
    public MotorRepository repository;

    public Motor getMotor(){
        System.out.println(repository.findById(1L));
        return repository.findById(1L);}
}
