package ru.kpfu.itis.khakov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.khakov.entity.User;

import java.util.List;

/**
 * Created by Rus on 17.04.2016.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByLogin(String login);
    User findById(Long id);
    List<User> findAllByOrderByIdDesc();
    List<User> findAllByOrderByFirstNameAsc();
    List<User> findAllByOrderByLastNameAsc();
    List<User> findAllByOrderByFirstNameDesc();
    List<User> findAllByOrderByLastNameDesc();
    List<User> findAllByOrderByLoginAsc();
    List<User> findAllByOrderByLoginDesc();
    List<User> findAllByOrderByEnabledAsc();
    List<User> findAllByOrderByEnabledDesc();
    List<User> findAllByOrderByRoleAsc();
    List<User> findAllByOrderByRoleDesc();
}
