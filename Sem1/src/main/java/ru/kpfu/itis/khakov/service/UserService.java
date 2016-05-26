package ru.kpfu.itis.khakov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.khakov.entity.User;
import ru.kpfu.itis.khakov.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rus on 26.04.2016.
 */
@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;

    @Transactional
    public User getByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Transactional
    public User getById(Long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public User changeUser(Long id, String role, boolean enabled) {
        User user = userRepository.findById(id);
        System.out.println(user);
        user.setEnabled(enabled);
        user.setRole(role);
        return userRepository.saveAndFlush(user);
    }

    @Transactional
    public User add(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Transactional
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public List<User> OrderByLoginAsc() {
        return userRepository.findAllByOrderByLoginAsc();
    }

    @Transactional
    public List<User> OrderByLoginDesc() {
        return userRepository.findAllByOrderByLoginDesc();
    }

    @Transactional
    public List<User> OrderByRoleDesc() {
        return userRepository.findAllByOrderByRoleDesc();
    }

    @Transactional
    public List<User> OrderByRoleAsc() {
        return userRepository.findAllByOrderByRoleAsc();
    }

    @Transactional
    public List<User> OrderByIdDesc() {
        return userRepository.findAllByOrderByIdDesc();
    }

    @Transactional
    public List<User> OrderByFirstNameDesc() {
        return userRepository.findAllByOrderByFirstNameDesc();
    }

    @Transactional
    public List<User> OrderByFirstNameAsc() {
        return userRepository.findAllByOrderByFirstNameAsc();
    }

    @Transactional
    public List<User> OrderByLastNameDesc() {
        return userRepository.findAllByOrderByLastNameDesc();
    }

    @Transactional
    public List<User> OrderByLastNameAsc() {
        return userRepository.findAllByOrderByLastNameAsc();
    }

    @Transactional
    public List<User> OrderByEnableDesc() {
        return userRepository.findAllByOrderByEnabledDesc();
    }

    @Transactional
    public List<User> OrderByEnableAsc() {
        return userRepository.findAllByOrderByEnabledAsc();
    }
    @Transactional
    public List<User> selectByName(String name) {
        return userRepository.findByFirstNameContainingOrLastNameContaining(name, name);
    }
}
