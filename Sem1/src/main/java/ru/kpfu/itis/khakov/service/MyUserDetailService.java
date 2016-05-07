package ru.kpfu.itis.khakov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.khakov.entity.User;
import ru.kpfu.itis.khakov.repository.UserRepository;



/**
 * Created by Rus on 20.04.2016.
 */
@Component
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    public UserService userService;
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userService.getByLogin(login);
        if (user == null) throw new UsernameNotFoundException("User with name " + login + " not found");
        return user;
    }
}

