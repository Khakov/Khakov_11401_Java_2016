package ru.kpfu.itis.khakov;

import ru.kpfu.itis.khakov.entity.Attribute;
import ru.kpfu.itis.khakov.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import ru.kpfu.itis.khakov.controllers.*;

import java.io.IOException;
import java.util.List;

@Lazy
@SpringBootApplication
public class MainApplication extends AbstractJavaFxApplicationSupport {

    CurrentPage currentPage = CurrentPage.LOGIN;

    @Qualifier("mainLoader")
    @Autowired
   
    private User user = null;
    private MenuController menuController = null;

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Terminal");
        initRootLayout();
        showLogin();
    }

    /**
     * Инициализирует корневой макет.
     */
    public void initRootLayout() {
        System.out.println(menuLoader.getRoot().toString());
        rootLayout = (BorderPane) menuLoader.getRoot();
        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
        menuController = menuLoader.getController();
        menuController.setMainApp(this);
    }

    public void showLogin() {
       
    }

    public void showCredit() {
        
    }

    public void showCatalog() {
        
    }
    public void showTest() {
       
    }
    public void showAttributes() {
        
    }

    public void showResult() {
        
    }


    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public CurrentPage getCurrentPage() {
        return currentPage;
    }

    public MenuController getMenuController() {
        return menuController;
    }

    public static void main(String[] args) {
        launchApp(MainApplication.class, args);
    }
}
