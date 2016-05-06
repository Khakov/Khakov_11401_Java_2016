package ru.kpfu.itis.khakov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.khakov.entity.*;
import ru.kpfu.itis.khakov.service.*;

import java.util.List;

/**
 * Created by Rus on 04.05.2016.
 */
@Controller
@RequestMapping("/operator")
public class OperatorController {
    @Autowired
    CreditService creditService;
    @Autowired
    StatusService statusService;
    @Autowired
    TestDriveService driveService;
    @Autowired
    RemontService remontService;
    @Autowired
    ResultService resultService;
    @Autowired
    MyCarService myCarService;
    @RequestMapping(value = "/credits", method = RequestMethod.GET)
    public String getCredits(ModelMap model) {
        List<Credit> credits = creditService.getCreditByStatus("в обработке");
        List<Credit> credits1 = creditService.getCreditByStatus("одобрен");
        List<Credit> credits2 = creditService.getCreditByStatus("отказан");
        List<Credit> credits3 = creditService.getCreditByStatus("получен");

        model.put("credits", credits);
        model.put("credits1", credits1);
        model.put("credits2", credits2);
        model.put("credits3", credits3);
        return "operator/operator_credit";
    }

    @RequestMapping(value = "/edit_credit/{id}", method = RequestMethod.GET)
    public String getCredit(ModelMap model, @PathVariable("id") Long id) {
        List<Status> statuses = statusService.getAll();
        Credit credit = creditService.getById(id);
        model.put("statuses", statuses);
        model.put("credit", credit);
        return "operator/edit_credit";
    }

    @RequestMapping(value = "/edit_credit/{id}", method = RequestMethod.POST)
    public String setCredit(ModelMap model, @PathVariable("id") Long id, @RequestParam("status") String status) {
        creditService.changeStatus(id, Long.valueOf(status));
        return "redirect:/operator/credits";
    }
    @RequestMapping(value = "/test_drive", method = RequestMethod.GET)
    public String getTestDrives(ModelMap model) {
        List<TestDrive> drives = driveService.getByStatus("в обработке");
        List<TestDrive> drives1 = driveService.getByStatus("одобрен");
        List<TestDrive> drives2 = driveService.getByStatus("отказан");
        List<TestDrive> drives3 = driveService.getByStatus("получен");
        model.put("drives", drives);
        model.put("drives1", drives1);
        model.put("drives2", drives2);
        model.put("drives3", drives3);
        return "operator/operator_drive";
    }
    @RequestMapping(value = "/edit_drive/{id}", method = RequestMethod.GET)
    public String getTestDrive(ModelMap model, @PathVariable("id") Long id) {
        List<Status> statuses = statusService.getAll();
        TestDrive drive = driveService.getById(id);
        model.put("statuses", statuses);
        model.put("drive", drive);
        return "operator/edit_drive";
    }
    @RequestMapping(value = "/edit_drive/{id}", method = RequestMethod.POST)
    public String setTestDrive(ModelMap model, @PathVariable("id") Long id, @RequestParam("status") String status,
                               @RequestParam("date") String date) {
        driveService.changeStatus(id, Long.valueOf(status), date);
        return "redirect:/operator/test_drive";
    }
    @RequestMapping(value = "/remont", method = RequestMethod.GET)
    public String getRemont(ModelMap model) {
        List<Remont> remonts = remontService.getByResult("в обработке");
        List<Remont> remonts1 = remontService.getByResult("идет ремонт");
        List<Remont> remonts2 = remontService.getByResult("проблема решена");
        List<Remont> remonts3 = remontService.getByResult("отказ");
        model.put("remonts", remonts);
        model.put("remonts1", remonts1);
        model.put("remonts2", remonts2);
        model.put("remonts3", remonts3);
        return "operator/operator_remont";
    }
    @RequestMapping(value = "/edit_remont/{id}", method = RequestMethod.GET)
    public String getRemont(ModelMap model, @PathVariable("id") Long id) {
        List<Result> results = resultService.getAll();
        Remont remont = remontService.getById(id);
        model.put("results", results);
        model.put("remont", remont);
        return "operator/edit_remont";
    }
    @RequestMapping(value = "/edit_remont/{id}", method = RequestMethod.POST)
    public String setRemont(ModelMap model, @PathVariable("id") Long id, @RequestParam("status") String status,
                               @RequestParam("date") String date) {
        remontService.changeResult(id, Long.valueOf(status));
        return "redirect:/operator/remont";
    }
    @RequestMapping(value="/cars", method = RequestMethod.GET)
    public String getCars(ModelMap model){
        List<MyCar> cars1 = myCarService.getByStatus(true);
        List<MyCar> cars2 = myCarService.getByStatus(false);
        System.out.println(cars1);
        model.put("cars2", cars2);
        model.put("cars1", cars1);
        return "operator/cars";
    }
    @RequestMapping(value = "/edit_car/{id}", method = RequestMethod.GET)
    public String getCar(@PathVariable("id") Long id, ModelMap model){
        MyCar car = myCarService.getById(id);
        model.put("car", car);
        return "operator/edit_car";
    }
    @RequestMapping(value = "/edit_car/{id}", method = RequestMethod.POST)
    public String getCar(@PathVariable("id") Long id, ModelMap model,
                         @RequestParam("status") String status){
        myCarService.changeCar(id, status);
        return "redirect:/operator/cars";
    }
}
