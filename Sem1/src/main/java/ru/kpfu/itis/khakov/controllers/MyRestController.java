package ru.kpfu.itis.khakov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.khakov.entity.*;
import ru.kpfu.itis.khakov.service.*;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.List;

@RequestMapping("/rest")
@RestController
public class MyRestController {

    @Autowired
    CarService carService;
    @Autowired
    UserService userService;
    @Autowired
    AttributesService attributesService;
    @Autowired
    CreditService creditService;
    @Autowired
    StatusService statusService;
    @Autowired
    TestDriveService driveService;

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Car> getInfo() {
        List<Car> cars = carService.getAllCar();
        return cars;
    }
    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public
    @ResponseBody
    User login(@RequestParam("login") String login, @RequestParam("password") String password) {
        User user;
        System.out.println(login + " " + password);
        if((user = userService.getByLogin(login))!=null){
            if(!md5Decoder(password).equals(user.getPassword()))
                user = null;
        }else
            user = null;
        return user;
    }
    @RequestMapping(value = "/attributes", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Attribute> getAttr() {
        List<Attribute> attributes = attributesService.getAll();
        return attributes;
    }
    @RequestMapping(value = "/api/credit", method = RequestMethod.POST)
    public
    @ResponseBody
    Boolean credit(@RequestParam("car_id") Long carId, @RequestParam("name") String name,
                   @RequestParam("phone") String phone) {
        Boolean b;
        Credit credit = new Credit();
        credit.setDate(new Date(new java.util.Date().getTime()));
        credit.setNumber(phone);
        credit.setName(name);
        credit.setStatus(statusService.getById(1L));
        credit.setCar(carService.getById(carId));
        b = creditService.saveCredit(credit)!=null;
        return b;
    }
    @RequestMapping(value = "/api/test_drive", method = RequestMethod.POST)
    public
    @ResponseBody
    Boolean remont(@RequestParam("car_id") Long carId, @RequestParam("name") String name,
                   @RequestParam("phone") String phone, @RequestParam("date") String date) {
        Boolean b;
        TestDrive testDrive = new TestDrive();
        testDrive.setDate(date);
        testDrive.setNumber(phone);
        testDrive.setName(name);
        testDrive.setStatus(statusService.getById(1L));
        testDrive.setCar(carService.getById(carId));
        b = driveService.saveTestDrive(testDrive)!=null;
        return b;
    }
    @RequestMapping(value = "/api/credits", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Credit> credits(@RequestParam("id") Long id) {
        System.out.println(id);

        List<Credit> credits = creditService.getByUser(userService.getById(id));
        return credits;
    }



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
