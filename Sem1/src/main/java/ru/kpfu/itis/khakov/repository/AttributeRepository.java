package ru.kpfu.itis.khakov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.khakov.entity.Attribute;

/**
 * Created by Rus on 17.04.2016.
 */
@Repository
public interface AttributeRepository extends JpaRepository<Attribute,Long> {
}
