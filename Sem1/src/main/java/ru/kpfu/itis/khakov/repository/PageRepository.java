package ru.kpfu.itis.khakov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.khakov.entity.Car;
import ru.kpfu.itis.khakov.entity.Page;

import java.util.List;

/**
 * Created by Rus on 06.05.2016.
 */
@Repository
public interface PageRepository extends JpaRepository<Page,Long> {
    List<Page> findByCar(Car car);
}
