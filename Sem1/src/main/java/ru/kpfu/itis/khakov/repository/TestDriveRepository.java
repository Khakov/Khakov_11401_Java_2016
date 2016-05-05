package ru.kpfu.itis.khakov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.khakov.entity.Status;
import ru.kpfu.itis.khakov.entity.TestDrive;
import ru.kpfu.itis.khakov.entity.User;

import java.util.List;

/**
 * Created by Rus on 04.05.2016.
 */
@Repository
public interface TestDriveRepository extends JpaRepository<TestDrive, Long> {
    List<TestDrive> findByUser(User user);

    List<TestDrive> findByStatus(Status status);

    TestDrive findById(Long id);
}
