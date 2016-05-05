package ru.kpfu.itis.khakov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.khakov.entity.Credit;
import ru.kpfu.itis.khakov.entity.Status;
import ru.kpfu.itis.khakov.entity.User;

import java.util.List;

/**
 * Created by Rus on 03.05.2016.
 */
@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {
    List<Credit> findByUser(User user);
    List<Credit> findByStatus(Status status);
    Credit findById(Long id);
}
