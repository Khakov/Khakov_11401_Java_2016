package ru.kpfu.itis.khakov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.khakov.entity.Attribute;
import ru.kpfu.itis.khakov.repository.AttributeRepository;

import java.util.List;

/**
 * Created by Rus on 20.04.2016.
 */
@Service
public class AttributesService {
    @Autowired
    AttributeRepository attributeRepository;
    public List<Attribute> getAll() {
        return attributeRepository.findAll();
    }
}
