package ru.kpfu.itis.khakov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Rus on 06.05.2016.
 */
@Controller
@RequestMapping(value = "/")
public class MainController {
    @RequestMapping(method = RequestMethod.GET)
    public String getMainPage() {
        return "main";
    }
}
