package ru.kpfu.itis.khakov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.khakov.entity.Result;
import ru.kpfu.itis.khakov.repository.ResultRepository;

import java.util.List;

/**
 * Created by Rus on 04.05.2016.
 */
@Service
public class ResultService {
    @Autowired
    public ResultRepository resultRepository;

    @Transactional
    public Result getByName(String s) {
        return resultRepository.findByResult(s);
    }

    @Transactional
    public List<Result> getAll() {
        return resultRepository.findAll();
    }
}
