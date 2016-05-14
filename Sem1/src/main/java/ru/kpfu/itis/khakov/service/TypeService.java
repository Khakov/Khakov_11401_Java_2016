package ru.kpfu.itis.khakov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.khakov.entity.Type;
import ru.kpfu.itis.khakov.repository.TypeRepository;

import java.util.List;

/**
 * Created by Rus on 04.05.2016.
 */
@Service
public class TypeService {
    @Autowired
    public TypeRepository typeRepository;

    @Transactional
    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

    @Transactional
    public Type getById(Long id) {
        return typeRepository.findById(id);
    }

    @Transactional
    public void delete(Long id) {
        typeRepository.delete(typeRepository.findById(id));
    }

    @Transactional
    public Type add(String type) {
        Type type1 = new Type();
        type1.setType(type);
        return typeRepository.saveAndFlush(type1);
    }
}
