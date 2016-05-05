package ru.kpfu.itis.khakov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Rus on 02.04.2016.
 */
@Controller
public class AdminController {
    @RequestMapping(value="/admin", method = RequestMethod.GET)
    public String process(ModelMap model){
        model.put("ftl","Hi Carl!!!");
        return "admin";
    }
}
