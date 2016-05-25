package ru.kpfu.itis.khakov.controllers;

import ru.kpfu.itis.khakov.MainApplication;
import ru.kpfu.itis.khakov.entity.Attribute;
import ru.kpfu.itis.khakov.entity.Car;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


/**
 * Created by Rus on 25.05.2016.
 */
public class AttributeController {
    @FXML
    private TableView<Attribute> attributes;
    @FXML
    private TableColumn<Attribute,String> name;
    @FXML
    private TableColumn<Attribute,String> description;
    @FXML
    private TableColumn<Attribute,String> price;
    private MainApplication mainApp;
    private Car car;

    public void setCar(Car car) {
        this.car = car;
    }

    public void setMainApp(MainApplication mainApp) {
        this.mainApp = mainApp;
        attributes.setItems(mainApp.getAttributes());
    }

    @FXML
    public void initialize() {
        name.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        description.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescription()));
        price.setCellValueFactory(cellData -> new SimpleStringProperty(Math.round(cellData.getValue().getPrice() * car.getKof()) + ""));
    }
}
