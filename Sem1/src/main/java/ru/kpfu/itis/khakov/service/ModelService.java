package ru.kpfu.itis.khakov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.khakov.entity.Model;
import ru.kpfu.itis.khakov.repository.ModelRepository;

import java.util.List;

/**
 * Created by Rus on 20.04.2016.
 */
@Service
public class ModelService {
    @Autowired
    ModelRepository modelRepository;
    @Transactional
    public Model getById(Long id) {
        return modelRepository.findById(id);
    }
    @Transactional
    public List<Model> getAll(){
        return modelRepository.findAll();
    }

}
