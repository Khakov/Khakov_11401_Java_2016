package ru.kpfu.itis.khakov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.khakov.entity.User;
import ru.kpfu.itis.khakov.forms.RegistrationForm;
import ru.kpfu.itis.khakov.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Rus on 26.04.2016.
 */
@Controller
public class RegistrationController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private UserService userService;
    /**
     * Отображение страницы регистрации
     */
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String renderRegistrationPage() {
        if(request.getRemoteUser() != null){
            return "redirect:/";
        }
        request.setAttribute("regForm", new RegistrationForm());
        return "registration";
    }

    /**
     * Обработка формы Регистрации
     */
    @RequestMapping( value = "/registration", method = RequestMethod.POST)
    public String registrationForm(
            @Valid @ModelAttribute("regForm") RegistrationForm regForm,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if(userService.getByLogin(regForm.getEmail()) != null){
            model.addAttribute("error","Такой пользователь уже существует");
            return "registration";
        }
        else {
            if(!regForm.getPassword().equals(regForm.getConfirmPassword())){
                model.addAttribute("error","пароли не совпадают!");
                return "registration";
            }
        }
        String role = "ROLE_USER";
        User user = new User(regForm.getFirstName(), regForm.getLastName(), regForm.getEmail(),
                md5Decoder(regForm.getPassword()),role);
        user.setNumber(regForm.getPhone());
        userService.add(user);
        System.out.println(user);
        System.out.println(regForm);
        return "redirect:/";
    }

    /**
     * MD5 хэширование пароля
     */
    private String md5Decoder(String password){
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        messageDigest.update(password.getBytes(),0, password.length());
        String pass = new BigInteger(1,messageDigest.digest()).toString(16);
        if (pass.length() < 32) {
            pass = "0" + pass;
        }
        return pass;
    }
}
