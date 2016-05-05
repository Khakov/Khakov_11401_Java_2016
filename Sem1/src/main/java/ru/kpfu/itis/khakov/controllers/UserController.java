package ru.kpfu.itis.khakov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.khakov.entity.Credit;
import ru.kpfu.itis.khakov.entity.Remont;
import ru.kpfu.itis.khakov.entity.TestDrive;
import ru.kpfu.itis.khakov.entity.User;
import ru.kpfu.itis.khakov.service.CreditService;
import ru.kpfu.itis.khakov.service.RemontService;
import ru.kpfu.itis.khakov.service.TestDriveService;
import ru.kpfu.itis.khakov.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Rus on 24.04.2016.
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    CreditService creditService;
    @Autowired
    TestDriveService driveService;
    @Autowired
    RemontService remontService;
    @RequestMapping(value = "/profile")
    public String getProfile(ModelMap model){
        User user = userService.getByLogin(request.getUserPrincipal().getName());
        model.put("user", user);
        model.put("uri", request.getRequestURI());
        List<Credit> credits = creditService.getByUser(user);
        System.out.println(user);
        System.out.println(credits);
        if(!credits.isEmpty())
        model.put("credits", credits);
        List<TestDrive> drives = driveService.getByUser(user);
        if(!drives.isEmpty())
            model.put("drives",drives);
        List<Remont> remonts = remontService.findByUser(user);
        if(!remonts.isEmpty())
            model.put("remonts",remonts);
        return "profile";
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String getMainPage(){
        return "main";
    }


    @RequestMapping(value="/users", method = RequestMethod.GET)
    String get(ModelMap model){
        model.put("users", userService.getAllUsers());
        return "users";
    }
    @RequestMapping(value="/user", method = RequestMethod.GET)
    @ResponseBody List<User> getUser(@RequestParam("q") String q){
        List<User> users = userService.getAllUsers();
        if(q.contains("0")){
            if(q.startsWith("ma")) users = userService.OrderByLoginAsc();
            if(q.startsWith("fn")) users = userService.OrderByFirstNameAsc();
            if(q.startsWith("ln"))users = userService.OrderByLastNameAsc();
            if(q.startsWith("ro")) users = userService.OrderByRoleAsc();
            if(q.startsWith("en")) users = userService.OrderByEnableAsc();
        }
        else{
            if(q.startsWith("ma")) users = userService.OrderByLoginDesc();
            if(q.startsWith("fn")) users = userService.OrderByFirstNameDesc();
            if(q.startsWith("ln")) users = userService.OrderByLastNameDesc();
            if(q.startsWith("ro")) users = userService.OrderByRoleDesc();
            if(q.startsWith("en")) users = userService.OrderByEnableDesc();
            if(q.startsWith("id")) users = userService.OrderByIdDesc();
        }
        return users;
    }
    @RequestMapping(value="/edit_user/{id}", method = RequestMethod.GET)
    public String getThisUser(@PathVariable("id") Long id, ModelMap model){
        User user = userService.getById(id);
        if(user==null)
            return "404_error";
        else {
            model.put("user", user);
        }
        return "edit_user";
    }
    @RequestMapping(value="/edit_user/{id}", method = RequestMethod.POST)
    public String editUser(@RequestParam("id") Long id, @RequestParam("role") String role,
                           @RequestParam("enabled") boolean enabled, ModelMap model ) {
        userService.changeUser(id,role,enabled);
        model.put("users", userService.getAllUsers());
        return "redirect:/users";}
}
