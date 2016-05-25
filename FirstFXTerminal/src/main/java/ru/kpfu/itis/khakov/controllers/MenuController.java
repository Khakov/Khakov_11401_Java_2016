package ru.kpfu.itis.khakov.controllers;

import ru.kpfu.itis.khakov.MainApplication;
import javafx.fxml.FXML;

/**
 * Created by Rus on 20.05.2016.
 */
public class MenuController {
    private MainApplication mainApp;

    public void setMainApp(MainApplication mainApp) {
        this.mainApp = mainApp;
    }

//    @FXML
//    MenuItem loginItem;
    @FXML
    private void handleCredit() {
        if (mainApp.getCurrentPage() != CurrentPage.CREDIT) {
            mainApp.showCredit();
        }
    }

    @FXML
    private void handleLogin() {
        if (mainApp.getCurrentPage() != CurrentPage.LOGIN) {
            mainApp.showLogin();
        }
    }
    @FXML
    private void handleCatalog(){
        if(mainApp.getCurrentPage() != CurrentPage.CATALOG){
            mainApp.showCatalog();
        }
    }
    @FXML
    private void handleTest(){
        if(mainApp.getCurrentPage() != CurrentPage.TEST){
            mainApp.showTest();
        }
    }
    @FXML
    private void handleHistoryCredit(){
        if(mainApp.getCurrentPage() != CurrentPage.HISTORY){
            mainApp.showCreditHistory();
        }
    }

    public void setLogin(String login) {

    }
}