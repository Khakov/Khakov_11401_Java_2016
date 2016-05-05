package ru.kpfu.itis.khakov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Rus on 23.04.2016.
 */
@Controller
public class LogoutController {
    @RequestMapping(value="/logout")
    public String logout(){
        return "logout";
    }
}
