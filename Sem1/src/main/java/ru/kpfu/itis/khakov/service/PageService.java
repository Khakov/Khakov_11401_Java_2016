package ru.kpfu.itis.khakov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.khakov.entity.Car;
import ru.kpfu.itis.khakov.entity.Page;
import ru.kpfu.itis.khakov.repository.PageRepository;

import java.util.List;

/**
 * Created by Rus on 06.05.2016.
 */
@Service
public class PageService {
    @Autowired
    PageRepository pageRepository;
    public List<Page> getByCar(Car car){
        return pageRepository.findByCar(car);
    }
}
