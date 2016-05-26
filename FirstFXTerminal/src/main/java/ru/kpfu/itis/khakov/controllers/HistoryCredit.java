package ru.kpfu.itis.khakov.controllers;

import javafx.collections.FXCollections;
import ru.kpfu.itis.khakov.MainApplication;
import ru.kpfu.itis.khakov.entity.Credit;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

public class HistoryCredit {
    @FXML
    private TableView<Credit> tableCars;
    private ObservableList<Credit> credits  = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Credit, String> name;
    @FXML
    private TableColumn<Credit, String> car;
    @FXML
    private TableColumn<Credit, String> number;
    @FXML
    private TableColumn<Credit, String> date;
    @FXML
    private TableColumn<Credit, String> status;
    private MainApplication mainApp;
    public void setMainApp(MainApplication mainApp) {
        this.mainApp = mainApp;
        initCredits();
        tableCars.setItems(credits);
    }

    private void initCredits() {
        if (credits.size() == 0) {
            try {
                RestTemplate restTemplate = new RestTemplate();
                String url = "http://localhost:8080/rest/api/credits";
                ObjectMapper objectMapper = new ObjectMapper();
                HttpHeaders headers = new HttpHeaders();
                headers.add("Authorization", mainApp.getUser().getHeader());
                MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
                params.add("id", mainApp.getUser().getId() + "");
                HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(params, headers);
                String json = restTemplate.exchange(url, HttpMethod.GET, request,String.class).getBody();
                List<Credit> creditList = objectMapper.readValue(json,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Credit.class));
                credits.addAll(creditList);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ResourceAccessException e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initOwner(mainApp.getPrimaryStage());
                alert.setTitle("Нет соединения с сервером");
                alert.setContentText("Внимание!Ошибка соединения с сервером!");
                alert.showAndWait();
                mainApp.showLogin();
            }
        }
    }

    @FXML
    public void initialize() {
        number.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumber()));
        name.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        date.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDate().toString()));
        car.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCar().toString()));
        status.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStatus().getStatus()));
    }
}
