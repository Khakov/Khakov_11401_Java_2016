package ru.kpfu.itis.khakov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.khakov.entity.MyCar;

import java.sql.Date;
import java.util.List;

/**
 * Created by Rus on 06.05.2016.
 */
@Repository
public interface MyCarRepository extends JpaRepository<MyCar, Long> {
    List<MyCar> findByDate(Date date);

    List<MyCar> findAllByDate(Date date);
}
