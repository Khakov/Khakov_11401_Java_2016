package ru.kpfu.itis.khakov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.khakov.entity.Credit;
import ru.kpfu.itis.khakov.entity.Status;
import ru.kpfu.itis.khakov.entity.User;
import ru.kpfu.itis.khakov.repository.CreditRepository;
import ru.kpfu.itis.khakov.repository.StatusRepository;

import java.util.List;

/**
 * Created by Rus on 03.05.2016.
 */
@Service
public class CreditService {
    @Autowired
    public CreditRepository creditRepository;
    @Autowired
    public StatusRepository statusRepository;

    @Transactional
    public Credit saveCredit(Credit credit) {
        return creditRepository.saveAndFlush(credit);
    }

    @Transactional
    public List<Credit> getByUser(User user) {
        return creditRepository.findByUser(user);
    }

    @Transactional
    public List<Credit> getByStatus(Status status) {
        return creditRepository.findByStatus(status);
    }

    @Transactional
    public Credit getById(Long id) {
        return creditRepository.findById(id);
    }

    public List<Credit> getCreditByStatus(String status) {
        return creditRepository.findByStatus(statusRepository.findByStatus(status));
    }

    @Transactional
    public Credit changeStatus(Long id, Long status) {
        Credit credit = creditRepository.findById(id);
        credit.setStatus(statusRepository.findById(status));
       return creditRepository.saveAndFlush(credit);
    }

    @Transactional
    public List<Credit> getAll() {
        return creditRepository.findAll();
    }
}
