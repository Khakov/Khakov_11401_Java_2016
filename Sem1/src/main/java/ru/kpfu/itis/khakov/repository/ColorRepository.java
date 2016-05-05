package ru.kpfu.itis.khakov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.khakov.entity.Color;

/**
 * Created by Rus on 17.04.2016.
 */
@Repository
public interface ColorRepository extends JpaRepository<Color,Long> {
    Color findById(Long id);
}
