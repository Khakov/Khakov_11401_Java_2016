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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import ru.kpfu.itis.khakov.MainApplication;
import ru.kpfu.itis.khakov.entity.Credit;
import ru.kpfu.itis.khakov.entity.TestDrive;

import java.io.IOException;
import java.util.List;

/**
 * Created by Rus on 26.05.2016.
 */
public class HistoryTest {
    @FXML
    private TableView<TestDrive> tableCars;
    private ObservableList<TestDrive> drives = FXCollections.observableArrayList();
    @FXML
    private TableColumn<TestDrive, String> name;
    @FXML
    private TableColumn<TestDrive, String> car;
    @FXML
    private TableColumn<TestDrive, String> number;
    @FXML
    private TableColumn<TestDrive, String> date;
    @FXML
    private TableColumn<TestDrive, String> status;
    private MainApplication mainApp;
    public void setMainApp(MainApplication mainApp) {
        this.mainApp = mainApp;
        initCredits();
        tableCars.setItems(drives);
    }

    private void initCredits() {
        if (drives.size() == 0) {
            try {
                RestTemplate restTemplate = new RestTemplate();
                String url = "http://localhost:8080/rest/api/test_history?id=" + mainApp.getUser().getId();
                ObjectMapper objectMapper = new ObjectMapper();
                HttpHeaders headers = new HttpHeaders();
                headers.add("Authorization", mainApp.getUser().getHeader());
                MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
                HttpEntity<String> request = new HttpEntity<String>(headers);
                String json = restTemplate.exchange(url, HttpMethod.GET, request,String.class).getBody();
                List<TestDrive> testDrives = objectMapper.readValue(json,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, TestDrive.class));
                drives.addAll(testDrives);
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
        date.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDate()));
        car.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCar().toString()));
        status.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStatus().getStatus()));
    }
}
