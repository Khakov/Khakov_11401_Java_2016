package ru.kpfu.itis.khakov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.khakov.entity.Car;

/**
 * Created by Rus on 17.04.2016.
 */
@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
    Car findById(Long id);
}
