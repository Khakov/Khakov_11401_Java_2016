package ru.kpfu.itis.khakov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.khakov.entity.Status;
import ru.kpfu.itis.khakov.repository.StatusRepository;

import java.util.List;

/**
 * Created by Rus on 03.05.2016.
 */
@Service
public class StatusService {
    @Autowired
    StatusRepository statusRepository;
    @Transactional
    public Status getByStatus(String status){
        return statusRepository.findByStatus(status);
    }
    @Transactional
    public List<Status> getAll() {
        return statusRepository.findAll();
    }
@Transactional
    public Status getById(Long id) {
        return statusRepository.findById(id);
    }

}
