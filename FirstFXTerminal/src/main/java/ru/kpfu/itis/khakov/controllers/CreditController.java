package ru.kpfu.itis.khakov.controllers;

import ru.kpfu.itis.khakov.MainApplication;
import ru.kpfu.itis.khakov.entity.Car;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Rus on 25.05.2016.
 */
public class CreditController {

    @FXML
    private TextField name;
    @FXML
    private TextField phone;
    @FXML
    private ChoiceBox<Car> cars;
    private MainApplication mainApp;
    public void setMainApp(MainApplication mainApp) {
        this.mainApp = mainApp;
        cars.setItems(mainApp.getCars());
        cars.setValue(mainApp.getCars().get(0));
        if(mainApp.getUser()!= null){
            name.setText(mainApp.getUser().getFirstName());
            phone.setText(mainApp.getUser().getNumber());
        }
    }
    @FXML
    private void handleCredit(){
        System.out.println(mainApp.getUser().getHeader());
        Pattern pattern = Pattern.compile("(\\d{8,11})");
        Matcher m = pattern.matcher(phone.getText());
        boolean bool = m.find();
        if(bool && name.getText()!=null){
            cars.getValue();
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://localhost:8080/rest/api/credit";
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", mainApp.getUser().getHeader()); //here is some login and pass like this login:pass
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
                params.add("car_id", cars.getValue().getId() + "");
                params.add("name", name.getText());
                params.add("phone", phone.getText());
                HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(params, headers);
                Boolean b = restTemplate.postForEntity(url, request, Boolean.class).getBody();
                if(b) {
                    mainApp.showResult();
                }
            } catch (HttpClientErrorException e) {
                e.printStackTrace();
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Ошибка");
            String error = "Опачки... вышли следущие ошибки:";
                error += "\n-введите дату!";
            if (name.getText()== null)
                error += "\n-введите имя!";
            if (bool)
                error +="\n-номер должен содержать от 8 до 11 цифр!";
            alert.setContentText(error);
            alert.showAndWait();
        }
    }
}
