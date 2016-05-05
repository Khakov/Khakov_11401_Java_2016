package ru.kpfu.itis.khakov.controllers;

import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.khakov.entity.*;
import ru.kpfu.itis.khakov.forms.CreditForm;
import ru.kpfu.itis.khakov.forms.RemontForm;
import ru.kpfu.itis.khakov.forms.TestDirveForm;
import ru.kpfu.itis.khakov.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rus on 02.05.2016.
 */
@Controller
public class AutoController {
    @Autowired
    CarService carService;
    @Autowired
    UserService userService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    TestDriveService testDriveService;
    @Autowired
    StatusService statusService;
    @Autowired
    AttributesService attributes;
    @Autowired
    TypeService typeService;
    @Autowired
    ResultService resultService;
    @Autowired
    RemontService remontService;
    @Autowired
    MyCarService myCarService;
    @Autowired
    AttributesService attributesService;
    @Autowired
    ColorService colorService;
    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public String autoCatalog(ModelMap model) {
        List<Car> cars = carService.getAllCar();
        model.put("cars", cars);
        return "catalog";
    }

    @RequestMapping(value = "/car/{id}", method = RequestMethod.GET)
    public String getCar(ModelMap model, @PathVariable("id") Long id) {
        Car car = carService.getById(id);
        if (car == null)
            return "404_error";
        model.put("attributes", attributes.getAll());
        model.put("car", car);
        return "car";
    }

    @RequestMapping(value = "/test_drive", method = RequestMethod.GET)
    public String getTestDrive(ModelMap model) {
        TestDirveForm form = new TestDirveForm();
        if (request.getUserPrincipal() != null) {
            User user = userService.getByLogin(request.getUserPrincipal().getName());
            model.put("user", user);
            form.setFirstName(user.getFirstName());
            form.setNumber(user.getNumber());
        }
        request.setAttribute("driveForm", form);
        model.put("cars", carService.getAllCar());
        return "test_drive";
    }
    @RequestMapping(value = "/test_drive", method = RequestMethod.POST)
    public String setTestDrive(@Valid  @ModelAttribute("driveForm") TestDirveForm driveForm,
                               BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            model.put("cars", carService.getAllCar());
            return "test_drive";
        }
        TestDrive drive = new TestDrive();
        drive.setNumber(driveForm.getNumber());
        String[] dates = driveForm.getDate().split("/");
        String date = dates[1] + "." + dates[0] + "." + dates[2];
        drive.setDate(date);
        drive.setName(driveForm.getFirstName());
        drive.setCar(carService.getById(Long.valueOf(driveForm.getId())));
        drive.setStatus(statusService.getByStatus("в обработке"));
        if(request.getUserPrincipal()!=null){
            drive.setUser(userService.getByLogin(request.getUserPrincipal().getName()));
        }
        testDriveService.saveTestDrive(drive);
    return "redirect:/success_drive";
    }
    @RequestMapping(value = "/success_drive", method = RequestMethod.GET)
    public String getTestDrive(){
        return "success_credix";
    }

    @RequestMapping(value = "/remont", method = RequestMethod.GET)
    public String getRemontForm(ModelMap model){
        RemontForm form = new RemontForm();
        if (request.getUserPrincipal() != null) {
            User user = userService.getByLogin(request.getUserPrincipal().getName());
            model.put("user", user);
            form.setFirstName(user.getFirstName());
            form.setNumber(user.getNumber());
        }
        request.setAttribute("remontForm", form);
        model.put("cars", carService.getAllCar());
        model.put("types", typeService.getAllTypes());
        return "remont";
    }
    @RequestMapping(value = "/remont", method = RequestMethod.POST)
    public String setRemontForm(@Valid  @ModelAttribute("remontForm") RemontForm form,
                                BindingResult bindingResult, ModelMap model){
        if (bindingResult.hasErrors()) {
            model.put("cars", carService.getAllCar());
            model.put("types", typeService.getAllTypes());
            return "remont";
        }
        Remont remont = new Remont();
        remont.setNumber(form.getNumber());
        remont.setDate(new Date(new java.util.Date().getTime()));
        remont.setName(form.getFirstName());
        remont.setDescription(form.getDescription());
        remont.setCar(carService.getById(Long.valueOf(form.getId())));
        remont.setResult(resultService.getByName("в обработке"));
        remont.setType(typeService.getById(Long.valueOf(form.getType())));
        if(request.getUserPrincipal()!=null){
            remont.setUser(userService.getByLogin(request.getUserPrincipal().getName()));
        }
        remontService.saveRemont(remont);
        request.setAttribute("remont", remont);
        return "redirect:/success_credix";
    }
//    @RequestMapping(value = "/success_remont", method = RequestMethod.GET)
//    public String getSuccessRemont(){
//        return "success_remont";
//    }
    @RequestMapping(value="/add_my_car", method = RequestMethod.GET)
    public String getAuto(ModelMap model){
        if (request.getUserPrincipal() != null) {
            User user = userService.getByLogin(request.getUserPrincipal().getName());
            model.put("user", user);
        }
        model.put("cars",carService.getAllCar());
        model.put("attributes", attributesService.getAll());
        model.put("colors", colorService.getAll());
        return "add_my_car";
    }
    @RequestMapping(value="/add_my_car", method = RequestMethod.POST)
    public String setAuto(ModelMap model, @RequestParam("color") String color,
                          @RequestParam("car") String car){
        MyCar myCar = new MyCar();
        Color color1 = colorService.getById(Long.valueOf(color));
        Car car1 = carService.getById(Long.valueOf(car));
        myCar.setColor(color1);
        myCar.setCar(car1);
        myCar.setDate(new Date(new java.util.Date().getTime()));
        List<Attribute> attributes = new ArrayList<Attribute>();
        Long id = 1L;
        if (request.getUserPrincipal() != null) {
            User user = userService.getByLogin(request.getUserPrincipal().getName());
            myCar.setUser(user);
            id = user.getId();
        }
        for(Attribute attribute: attributesService.getAll()){
            if("on".equals(request.getParameter("attribute" + attribute.getId()))){
                attributes.add(attribute);
            }
        }
        myCarService.saveCar(myCar, attributes);
        request.getSession().setAttribute("myCar",myCar);
        return "redirect:/document/" + id;
    }
    @RequestMapping(value = "/document/{id}", method = RequestMethod.POST)
    public String getPdf(){
        return "document";
    }
}
