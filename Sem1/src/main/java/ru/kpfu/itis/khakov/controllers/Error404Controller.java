package ru.kpfu.itis.khakov.controllers;//package ru.kpfu.itis.khakov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Rus on 20.04.2016.
 */
@Controller
@RequestMapping(value = "/error404", method = RequestMethod.GET)
public class Error404Controller {
    @RequestMapping
    public String getErrorPage(@ModelAttribute("model") ModelMap model){
        return "ErrorPages/404_error";
    }
}
