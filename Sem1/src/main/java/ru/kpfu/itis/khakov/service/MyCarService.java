package ru.kpfu.itis.khakov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.khakov.entity.Attribute;
import ru.kpfu.itis.khakov.entity.MyCar;
import ru.kpfu.itis.khakov.entity.User;
import ru.kpfu.itis.khakov.repository.*;

import java.util.List;

/**
 * Created by Rus on 05.05.2016.
 */
@Service
public class MyCarService {
    @Autowired
    public MyCarRepository myCarRepository;

    @Transactional
    public MyCar saveCar(MyCar myCar, List<Attribute> attributes) {
        myCarRepository.saveAndFlush(myCar);
        List<MyCar> myCars = myCarRepository.findAllByDate(myCar.getDate());
        System.out.println(myCar.getId());
        for (MyCar car : myCars) {
            if (myCar.getUser().equals(car.getUser())){
                System.out.println(myCar.getDate());
            myCar = car;
            }
        }
        System.out.println(myCar.getDate());
        myCar.setAttributes(attributes);
       return myCarRepository.saveAndFlush(myCar);
    }

    @Transactional
    public List<MyCar> getAll() {
        return myCarRepository.findAll();
    }

    @Transactional
    public List<MyCar> getByStatus(Boolean b) {
        return myCarRepository.findByStatus(b);
    }

    @Transactional
    public MyCar getById(Long id) {
        return myCarRepository.findById(id);
    }

    @Transactional
    public MyCar changeCar(Long id, String status) {
        Boolean s = true;
        if (status.equals("0"))
            s = false;
        MyCar myCar = myCarRepository.findById(id);
        myCar.setStatus(s);
        return myCarRepository.saveAndFlush(myCar);
    }
@Transactional
    public List<MyCar> getByUser(User user) {
    return myCarRepository.findAllByUser(user);
    }
}