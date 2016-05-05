package ru.kpfu.itis.khakov.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.khakov.entity.Model;

/**
 * Created by Rus on 17.04.2016.
 */
@Repository
public interface ModelRepository extends CrudRepository<Model,Long> {
}
