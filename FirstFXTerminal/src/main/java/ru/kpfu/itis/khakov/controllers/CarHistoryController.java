package ru.kpfu.itis.khakov.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import ru.kpfu.itis.khakov.MainApplication;
import ru.kpfu.itis.khakov.entity.MyCar;

import java.io.IOException;
import java.util.List;

/**
 * Created by Rus on 27.05.2016.
 */
public class CarHistoryController {
    @FXML
    private TableView<MyCar> tableCars;
    private ObservableList<MyCar> myCars = FXCollections.observableArrayList();
    @FXML
    private TableColumn<MyCar, String> name;
    @FXML
    private TableColumn<MyCar, String> car;
    @FXML
    private TableColumn<MyCar, String> number;
    @FXML
    private TableColumn<MyCar, String> date;
    @FXML
    private TableColumn<MyCar, String> status;
    private MainApplication mainApp;
    public void setMainApp(MainApplication mainApp) {
        this.mainApp = mainApp;
        initMyCars();
        tableCars.setItems(myCars);
    }

    private void initMyCars() {
        if (myCars.size() == 0) {
            try {
                RestTemplate restTemplate = new RestTemplate();
                String url = "http://localhost:8080/rest/api/car_history?id=" + mainApp.getUser().getId();
                ObjectMapper objectMapper = new ObjectMapper();
                HttpHeaders headers = new HttpHeaders();
                headers.add("Authorization", mainApp.getUser().getHeader());
                HttpEntity<String> request = new HttpEntity<String>(headers);
                String json = restTemplate.exchange(url, HttpMethod.GET, request,String.class).getBody();
                List<MyCar> myCarList = objectMapper.readValue(json,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, MyCar.class));
                myCars.addAll(myCarList);
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
        name.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCar().toString()));
        number.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getColor().toString()));
        date.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDate().toString()));
        car.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCar().getPrice() + ""));
        status.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStatus().toString()));
    }
}
