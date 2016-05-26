package ru.kpfu.itis.khakov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.khakov.entity.*;
import ru.kpfu.itis.khakov.forms.*;
import ru.kpfu.itis.khakov.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by Rus on 02.04.2016.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    HttpServletRequest request;
    @Autowired
    CarService carService;
    @Autowired
    ModelService modelService;
    @Autowired
    ManufactureService manufactureService;
    @Autowired
    ColorService colorService;
    @Autowired
    CreditService creditService;
    @Autowired
    UserService userService;
    @Autowired
    RemontService remontService;
    @Autowired
    TypeService typeService;
    @Autowired
    AttributesService attributesService;

    @RequestMapping(method = RequestMethod.GET)
    public String process(ModelMap model) {
        List<Credit> credits = creditService.getCreditByStatus("в обработке");
        List<Credit> credits1 = creditService.getAll();
        List<User> users = userService.getAllUsers();
        List<Remont> remonts = remontService.getByResult("в обработке");
        List<Remont> remonts1 = remontService.getByResult("проблема решена");
        List<Remont> remonts2 = remontService.getAll();
        model.put("all_users", users.size());
        model.put("all_credits", credits1.size());
        model.put("credits", credits.size());
        model.put("all_remonts", remonts2.size());
        model.put("remonts_no", remonts.size());
        model.put("remonts_yes", remonts1.size());
        return "admin/admin";
    }

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public String getCars(ModelMap model) {
        model.put("cars", carService.getAllCar());
        return "admin/admin_cars";
    }

    @RequestMapping(value = "/edit_car/{id}", method = RequestMethod.GET)
    public String editCar(@PathVariable("id") Long id, ModelMap model) {
        CarForm carForm = new CarForm();
        Car car = carService.getById(id);
        if (car == null)
            return "ErrorPages/404_error";
        carForm.setKof(String.valueOf(car.getKof()));
        carForm.setManufacture(String.valueOf(car.getManufacture().getId()));
        carForm.setModel(String.valueOf(car.getModel().getId()));
        carForm.setPrice(car.getPrice());
        model.put("manufactures", manufactureService.getAll());
        model.put("models", modelService.getAll());
        model.put("car", car);
        request.setAttribute("carForm", carForm);
        return "admin/admin_add_car";
    }

    @RequestMapping(value = "/edit_car/{id}", method = RequestMethod.POST)
    public String editCars(@Valid @ModelAttribute("carForm") CarForm form, BindingResult bindingResult,
                           @PathVariable("id") Long id, ModelMap model) {
        if (bindingResult.hasErrors()) {
            model.put("manufactures", manufactureService.getAll());
            model.put("models", modelService.getAll());
            return "admin/admin_add_car";
        }
        Car car = carService.getById(id);
        CarManufacture manufacture = manufactureService.getById(Long.valueOf(form.getManufacture()));
        Model carModel = modelService.getById(Long.valueOf(form.getModel()));
        carService.editCar(car, manufacture, carModel, form.getPrice(), Double.parseDouble(form.getKof()));
        return "redirect:/admin/cars";
    }

    @RequestMapping(value = "/add_car", method = RequestMethod.GET)
    public String addCar(ModelMap model) {
        model.put("manufactures", manufactureService.getAll());
        model.put("models", modelService.getAll());
        request.setAttribute("carForm", new CarForm());
        return "admin/admin_edit_car";
    }

    @RequestMapping(value = "/add_car", method = RequestMethod.POST)
    public String editCars(@Valid @ModelAttribute("carForm") CarForm form, BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            model.put("manufactures", manufactureService.getAll());
            model.put("models", modelService.getAll());
            return "admin/admin_edit_car";
        }
        Car car = new Car();
        CarManufacture manufacture = manufactureService.getById(Long.valueOf(form.getManufacture()));
        Model carModel = modelService.getById(Long.valueOf(form.getModel()));
        car.setManufacture(manufacture);
        car.setPrice(form.getPrice());
        car.setModel(carModel);
        car.setKof(Double.valueOf(form.getKof()));
        carService.addCar(car);
        return "redirect:/admin/cars";
    }

    @RequestMapping(value = "/delete_car/{id}", method = RequestMethod.POST)
    public String deleteCar(@PathVariable("id") Long id) {
        carService.deleteCar(id);
        return "redirect:/admin/cars";
    }

    @RequestMapping(value = "/colors", method = RequestMethod.GET)
    public String getColors(ModelMap model) {
        model.put("colors", colorService.getAll());
        request.setAttribute("colorForm", new ColorForm());
        return "admin/colors";
    }

    @RequestMapping(value = "/add_color", method = RequestMethod.POST)
    public String editColor(@Valid @ModelAttribute("colorForm") ColorForm colorForm, BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            model.put("colors", colorService.getAll());
            return "admin/colors";
        }
        Color color = new Color();
        color.setColorRu(colorForm.getColorRu());
        color.setColorEn(colorForm.getColorEn());
        colorService.addColor(color);
        return "redirect:/admin/colors";
    }

    @RequestMapping(value = "/delete_color/{id}", method = RequestMethod.POST)
    public String editColor(@PathVariable("id") Long id, ModelMap model) {
        colorService.deleteColor(id);
        return "redirect:/admin/colors";
    }
    @RequestMapping(value = "/remonts", method = RequestMethod.GET)
    public String getRemonts(ModelMap model){
        model.put("types", typeService.getAllTypes());
        request.setAttribute("typeForm", new TypeForm());
        return "admin/type_remont";
    }
    @RequestMapping(value = "/add_remont", method = RequestMethod.POST)
    public String addRemontType(@Valid @ModelAttribute("typeForm") TypeForm typeForm,
                                BindingResult bindingResult, ModelMap model){
        if (bindingResult.hasErrors()) {
            model.put("types", typeService.getAllTypes());
            return "admin/type_remont";
        }
        typeService.add(typeForm.getType());
        return "redirect:/admin/remonts";
    }
    @RequestMapping(value = "/delete_remont/{id}", method = RequestMethod.POST)
    public String deleteRemontType(@PathVariable("id") Long id){
        typeService.delete(id);
        return "redirect:/admin/remonts";
    }
    @RequestMapping(value = "/attributes", method = RequestMethod.GET)
    public String getAttributes(ModelMap model){
        model.put("attributes", attributesService.getAll());
        request.setAttribute("attrForm", new AttributeForm());
        return "admin/attributes";
    }
    @RequestMapping(value = "/add_attribute", method = RequestMethod.POST)
    public String addAttrType(@Valid @RequestParam("attrForm") AttributeForm attrForm,
                                BindingResult bindingResult, ModelMap model){
        if (bindingResult.hasErrors()) {
            model.put("attributes", attributesService.getAll());
            return "admin/attributes";
        }
        attributesService.addAttribute(attrForm.getAttribute(), attrForm.getDescription(),
                attrForm.getPrice());
        return "redirect:/admin/attributes";
    }
    @RequestMapping(value = "/delete_attribute/{id}", method = RequestMethod.POST)
    public String deleteAttribute(@PathVariable("id") Long id){
        attributesService.delete(id);
        return "redirect:/admin/attributes";
    }
}