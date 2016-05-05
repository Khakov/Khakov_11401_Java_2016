package ru.kpfu.itis.khakov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.khakov.entity.Result;

/**
 * Created by Rus on 04.05.2016.
 */
@Repository
public interface ResultRepository extends JpaRepository<Result, Long>{
    Result findByResult(String s);
    Result findById(Long id);
}
