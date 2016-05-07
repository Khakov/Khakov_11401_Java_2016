package ru.kpfu.itis.khakov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.khakov.entity.Remont;
import ru.kpfu.itis.khakov.entity.Result;
import ru.kpfu.itis.khakov.entity.User;

import java.util.List;

/**
 * Created by Rus on 04.05.2016.
 */
@Repository
public interface RemontRepository extends JpaRepository<Remont, Long> {
    List<Remont> findByUser(User user);
    List<Remont> findByResult(Result result);
    Remont findById(Long id);
}
