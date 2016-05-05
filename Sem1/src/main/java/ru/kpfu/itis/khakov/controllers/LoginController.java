package ru.kpfu.itis.khakov.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.khakov.service.MotorService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    HttpServletRequest request;
    @RequestMapping(method = RequestMethod.GET)
    public String renderLoginPage() {
        if(request.getRemoteUser() != null){
            return "redirect:/";
        }
        return "login";
    }
}
