package ru.kpfu.itis.khakov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.khakov.entity.Color;
import ru.kpfu.itis.khakov.repository.ColorRepository;

import java.util.List;

/**
 * Created by Rus on 20.04.2016.
 */
@Service
public class ColorService {
    @Autowired
    public ColorRepository colorRepository;

    @Transactional
    public List<Color> getAll() {
        return colorRepository.findAll();
    }

    @Transactional
    public Color getById(Long id) {
        return colorRepository.findById(id);
    }

    @Transactional
    public Color addColor(Color color) {
       return colorRepository.saveAndFlush(color);
    }

    @Transactional
    public void deleteColor(Long id) {
        colorRepository.delete(colorRepository.findById(id));
    }
}
