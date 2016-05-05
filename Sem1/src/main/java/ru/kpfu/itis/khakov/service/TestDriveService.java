package ru.kpfu.itis.khakov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.khakov.entity.TestDrive;
import ru.kpfu.itis.khakov.entity.User;
import ru.kpfu.itis.khakov.repository.StatusRepository;
import ru.kpfu.itis.khakov.repository.TestDriveRepository;

import java.util.List;

/**
 * Created by Rus on 04.05.2016.
 */
@Service
public class TestDriveService {
    @Autowired
    TestDriveRepository testDriveRepository;
    @Autowired
    StatusRepository statusRepository;
    @Transactional
    public void saveTestDrive(TestDrive drive){
        testDriveRepository.saveAndFlush(drive);
    }
    @Transactional
    public List<TestDrive> getByUser(User user) {
        return testDriveRepository.findByUser(user);
    }
    @Transactional
    public List<TestDrive> getByStatus(String s) {
        return testDriveRepository.findByStatus(statusRepository.findByStatus(s));
    }
    @Transactional
    public TestDrive getById(Long id) {
        return testDriveRepository.findById(id);
    }
    @Transactional
    public void changeStatus(Long id, Long status, String date) {
        TestDrive drive = testDriveRepository.findById(id);
        drive.setStatus(statusRepository.findById(status));
        drive.setDate(date);
        testDriveRepository.saveAndFlush(drive);
    }
}
