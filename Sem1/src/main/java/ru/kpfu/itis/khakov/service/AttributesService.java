package ru.kpfu.itis.khakov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.khakov.entity.Attribute;
import ru.kpfu.itis.khakov.repository.AttributeRepository;

import java.util.List;

/**
 * Created by Rus on 20.04.2016.
 */
@Service
public class AttributesService {
    @Autowired
    public AttributeRepository attributeRepository;

    @Transactional
    public List<Attribute> getAll() {
        return attributeRepository.findAll();
    }

    @Transactional
    public Attribute getById(Long id) {
        return attributeRepository.findById(id);
    }

    @Transactional
    public void delete(Long id) {
        attributeRepository.delete(attributeRepository.findById(id));
    }

    @Transactional
    public Attribute addAttribute(String attribute, String description, Integer price) {
        Attribute attribute1 = new Attribute();
        attribute1.setName(attribute);
        attribute1.setPrice(price);
        attribute1.setDescription(description);
        return attributeRepository.saveAndFlush(attribute1);
    }
}
