package ru.kpfu.itis.khakov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.khakov.entity.Credit;
import ru.kpfu.itis.khakov.entity.User;
import ru.kpfu.itis.khakov.forms.CreditForm;
import ru.kpfu.itis.khakov.service.CarService;
import ru.kpfu.itis.khakov.service.CreditService;
import ru.kpfu.itis.khakov.service.StatusService;
import ru.kpfu.itis.khakov.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.Date;

/**
 * Created by Rus on 03.05.2016.
 */
@Controller
public class CreditController {
    @Autowired
    UserService userService;
    @Autowired
    CarService carService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    CreditService creditService;
    @Autowired
    StatusService statusService;
    @RequestMapping(value = "/credit", method = RequestMethod.GET)
    public String getCredit(ModelMap model){
        if(request.getUserPrincipal()!=null){
            User user = userService.getByLogin(request.getUserPrincipal().getName());
            model.put("user", user);
            request.setAttribute("creditForm", new CreditForm(user.getFirstName(), user.getId() + ""));
        }
        else
            request.setAttribute("creditForm", new CreditForm());
        model.put("cars", carService.getAllCar());
        return "user/credit";
}
    @RequestMapping(value = "/credit", method = RequestMethod.POST)
    public String setCredit(@Valid @ModelAttribute("creditForm") CreditForm creditForm,
                            BindingResult bindingResult, ModelMap model){
        if (bindingResult.hasErrors()) {
            model.put("cars", carService.getAllCar());
            return "user/credit";
        }
        Credit credit  = new Credit();

        if(request.getUserPrincipal()!=null){
            credit.setUser(userService.getByLogin(request.getUserPrincipal().getName()));
        }
        credit.setName(creditForm.getFirstName());
        credit.setNumber(creditForm.getNumber());
        credit.setCar(carService.getById(Long.valueOf(creditForm.getId())));
        credit.setDate(new Date(new java.util.Date().getTime()));
        credit.setStatus(statusService.getByStatus("в обработке"));
        creditService.saveCredit(credit);
        return "redirect:/success_credix";
    }
    @RequestMapping(value = "/success_credix")
    public String getSuccess(){
        return "success_credix";
    }
}
