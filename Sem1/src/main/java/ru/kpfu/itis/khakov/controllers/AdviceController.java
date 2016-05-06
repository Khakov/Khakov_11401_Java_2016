package ru.kpfu.itis.khakov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.kpfu.itis.khakov.service.UserService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Rus on 06.05.2016.
 */
@ControllerAdvice
public class AdviceController {
    @Autowired
    HttpServletRequest request;
    @Autowired
    UserService userService;
@ModelAttribute()
    public void init(ModelMap model) {
        if (request.getUserPrincipal()!=null){
            model.put("user", userService.getByLogin(request.getUserPrincipal().getName()));
        }
        model.put("uri", request.getRequestURI());
    }
}
