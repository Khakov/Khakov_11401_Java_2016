package ru.kpfu.itis.khakov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.khakov.entity.Status;

/**
 * Created by Rus on 03.05.2016.
 */
@Repository
public interface StatusRepository extends JpaRepository<Status, Long>{
    Status findByStatus(String status);
    Status findById(Long id);
}
