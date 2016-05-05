package ru.kpfu.itis.khakov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.khakov.entity.Type;

/**
 * Created by Rus on 04.05.2016.
 */
@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
    Type findById(Long id);
}
