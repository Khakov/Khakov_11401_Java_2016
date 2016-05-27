package ru.kpfu.itis.khakov.controllers;

import ru.kpfu.itis.khakov.MainApplication;
import ru.kpfu.itis.khakov.entity.Car;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Created by Rus on 26.05.2016.
 */
public class CatalogController {
    @FXML
    private Label manufacture;
    @FXML
    private Label model;
    @FXML
    private Label horsepower;
    @FXML
    private Label motor;
    @FXML
    private Label price;
    @FXML
    private Label litr;
    @FXML
    private TableView<Car> tableCars;

    @FXML
    private TableColumn<Car, String> thisCar;
    private MainApplication mainApp;
    public void setMainApp(MainApplication mainApp) {
        this.mainApp = mainApp;
        tableCars.setItems(mainApp.getCars());
    }
    @FXML
    public void initialize() {
        thisCar.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModel().getModel()));
        // заполняем таблицу данными
        showCarDetails(null);
        tableCars.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showCarDetails(newValue));
    }

    private void showCarDetails(Car car) {
        if (car != null) {
            manufacture.setText(car.getManufacture().getManufacture());
            model.setText(car.getModel().getModel());
            motor.setText(car.getModel().getMotor().getType());
            horsepower.setText(car.getModel().getMotor().getHorsepower() + "");
            litr.setText(car.getModel().getMotor().getConsumption() * car.getKof() + "");
            price.setText(car.getPrice() + "");
        } else {
            manufacture.setText("");
            model.setText("");
            horsepower.setText("");
            motor.setText("");
            litr.setText("");
            price.setText("");
        }
    }

    @FXML
    public void handleInfo(){
        Car selectedCar = tableCars.getSelectionModel().getSelectedItem();
        if (selectedCar != null) {
             mainApp.showAttributes(selectedCar);
        } else {
            // Ничего не выбрано.
           showMessage();
        }
    }
    private void showMessage(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.initOwner(mainApp.getPrimaryStage());
        alert.setTitle("No Selection");
        alert.setHeaderText("No Car Selected");
        alert.setContentText("Please select a car in the table.");
        alert.showAndWait();
    }
    @FXML
    public void handleCredit(){
        mainApp.showCredit(tableCars.getSelectionModel().getSelectedItem());
    }
    @FXML
    public void handleTest(){
        mainApp.showTest(tableCars.getSelectionModel().getSelectedItem());
    }
    @FXML
    public void handleBuy(){
        mainApp.showCar(tableCars.getSelectionModel().getSelectedItem());
    }
}
