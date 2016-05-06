package ru.kpfu.itis.khakov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.khakov.entity.CarManufacture;

/**
 * Created by Rus on 17.04.2016.
 */
@Repository
public interface ManufactureRepository extends JpaRepository<CarManufacture,Long> {
    CarManufacture findById(Long id);
}
