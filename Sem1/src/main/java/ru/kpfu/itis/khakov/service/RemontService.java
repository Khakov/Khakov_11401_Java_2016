package ru.kpfu.itis.khakov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.khakov.entity.Remont;
import ru.kpfu.itis.khakov.entity.User;
import ru.kpfu.itis.khakov.repository.RemontRepository;
import ru.kpfu.itis.khakov.repository.ResultRepository;

import java.util.List;

/**
 * Created by Rus on 04.05.2016.
 */
@Service
public class RemontService {
    @Autowired
    public RemontRepository remontRepository;
    @Autowired
    public ResultRepository resultRepository;

    @Transactional
    public Remont saveRemont(Remont remont) {
       return remontRepository.saveAndFlush(remont);
    }

    @Transactional
    public List<Remont> findByUser(User user) {
        return remontRepository.findByUser(user);
    }

    @Transactional
    public List<Remont> getByResult(String s) {
        return remontRepository.findByResult(resultRepository.findByResult(s));
    }

    @Transactional
    public Remont getById(Long id) {
        return remontRepository.findById(id);
    }

    @Transactional
    public Remont changeResult(Long id, Long result) {
        Remont remont = remontRepository.findById(id);
        remont.setResult(resultRepository.findById(result));
        return remontRepository.saveAndFlush(remont);
    }

    @Transactional
    public List<Remont> getAll() {
        return remontRepository.findAll();
    }
}
