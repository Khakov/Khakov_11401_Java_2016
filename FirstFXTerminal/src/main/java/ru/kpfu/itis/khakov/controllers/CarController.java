package ru.kpfu.itis.khakov.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.controlsfx.control.CheckComboBox;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import ru.kpfu.itis.khakov.MainApplication;
import ru.kpfu.itis.khakov.entity.Attribute;
import ru.kpfu.itis.khakov.entity.Car;
import ru.kpfu.itis.khakov.entity.Color;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Rus on 26.05.2016.
 */
public class CarController {
    @FXML
    private CheckComboBox<Attribute> attributes;
    @FXML
    private ChoiceBox<Color> colors;
    @FXML
    private ChoiceBox<Car> cars;
    private MainApplication mainApp;
    private Car car;

    public void setMainApp(MainApplication mainApp) {
//        attributes = new CheckComboBox<>(mainApp.getAttributes());
        attributes.getItems().addAll(mainApp.getAttributes());
        this.mainApp = mainApp;
        colors.setItems(mainApp.getColors());
        cars.setItems(mainApp.getCars());
        colors.setValue(mainApp.getColors().get(0));
        cars.setValue(mainApp.getCars().get(0));
        if(car!=null)
            cars.setValue(car);
    }

    @FXML
    private void handleTestDrive() {
            cars.getValue();
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://localhost:8080/rest/api/cars";
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", mainApp.getUser().getHeader());
            try {
                MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
                params.add("user_id", mainApp.getUser().getId() + "");
                params.add("color", colors.getValue().getId() + "");
                params.add("car", cars.getValue().getId() + "");
                String attr = "";
                for(Integer i: attributes.getCheckModel().getCheckedIndices()){
                    attr +="a"+i;
                }
                if(attr.equals(""))
                    attr = "-1";
                params.add("attr", attr);
                System.out.println(attr);
                HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
                Boolean b = restTemplate.postForEntity(url, request, Boolean.class).getBody();
                if (b) {
                    mainApp.showResult();
                }
            } catch (HttpClientErrorException e) {
                e.printStackTrace();
            }
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
