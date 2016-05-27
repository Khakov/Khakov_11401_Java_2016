package ru.kpfu.itis.khakov.controllers;

import ru.kpfu.itis.khakov.MainApplication;
import ru.kpfu.itis.khakov.entity.User;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by Rus on 20.05.2016.
 */
public class LoginController {
    private MainApplication mainApp;
    @FXML
    private TextField login;
    @FXML
    private PasswordField password;

    public void setMainApp(MainApplication mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleLogin() {
        String auth = login.getText() + ":" + password.getText();
        byte[] encodedAuth = Base64.encode(
                auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String(encodedAuth);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/rest/login";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", authHeader); //here is some login and pass like this login:pass
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
            params.add("login", login.getText());
            params.add("password", password.getText());
            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(params, headers);
            String json = restTemplate.postForEntity(url, request, String.class, params).getBody();
            User user;
            if (json!=null) {
                user = objectMapper.readValue(json, User.class);
                mainApp.setUser(user);
                mainApp.getUser().setPassword(password.getText());
                mainApp.showCatalog();
                mainApp.getMenuController().setLogin("log out");
            }
            else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initOwner(mainApp.getPrimaryStage());
                alert.setTitle("Неправильный логин или пароль");
                alert.setContentText("Неправильный логин или пароль");
                alert.showAndWait();
            }
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
