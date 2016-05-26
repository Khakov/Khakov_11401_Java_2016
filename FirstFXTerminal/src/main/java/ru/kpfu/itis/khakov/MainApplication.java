package ru.kpfu.itis.khakov;

import ru.kpfu.itis.khakov.entity.Attribute;
import ru.kpfu.itis.khakov.entity.Car;
import ru.kpfu.itis.khakov.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
    @Qualifier("creditHistoryLoader")
    @Autowired
    private FXMLLoader creditHistoryLoader;
    @Qualifier("testLoader")
    @Autowired
    private FXMLLoader testLoader;
    @Qualifier("resultLoader")
    @Autowired
    private FXMLLoader resultLoader;
    @Qualifier("loginLoader")
    @Autowired
    private FXMLLoader loginLoader;
    @Qualifier("catalogLoader")
    @Autowired
    private FXMLLoader catalogLoader;
    @Qualifier("mainLoader")
    @Autowired
    private FXMLLoader menuLoader;
    @Qualifier("creditLoader")
    @Autowired
    private FXMLLoader creditLoader;
    @Qualifier("attributeLoader")
    @Autowired
    private FXMLLoader attributeLoader;
    private User user = null;
    private MenuController menuController = null;

    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Car> cars = FXCollections.observableArrayList();
    private ObservableList<Attribute> attributes = FXCollections.observableArrayList();

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
        menuController.setLogin("log in");
        user =null;
        currentPage = CurrentPage.LOGIN;
        AnchorPane loginPage = (AnchorPane) loginLoader.getRoot();
        rootLayout.setCenter(loginPage);
        LoginController controller = loginLoader.getController();
        controller.setMainApp(this);
    }

    public void showCredit() {
        if (user == null)
            showLogin();
        else {
            currentPage = CurrentPage.CREDIT;
            AnchorPane creditPage = (AnchorPane) creditLoader.getRoot();
            rootLayout.setCenter(creditPage);
            CreditController controller = creditLoader.getController();
            controller.setMainApp(this);
        }
    }

    public void showCatalog() {
        currentPage = CurrentPage.CATALOG;
        CatalogController controller = catalogLoader.getController();
        controller.setMainApp(this);
        AnchorPane creditPage = (AnchorPane) catalogLoader.getRoot();
        rootLayout.setCenter(creditPage);
    }
    public void showTest() {
        currentPage = CurrentPage.TEST;
        AnchorPane testPage = (AnchorPane) testLoader.getRoot();
        rootLayout.setCenter(testPage);
        TestDriveController controller = testLoader.getController();
        controller.setMainApp(this);
    }
    public void showAttributes(Car car) {
        // Загружаем fxml-файл и создаём новую сцену
        // для всплывающего диалогового окна.
        AnchorPane page = (AnchorPane) attributeLoader.getRoot();

        // Создаём диалоговое окно Stage.
        Stage dialogStage = new Stage();
        dialogStage.setTitle("attributes");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Передаём адресата в контроллер.
        AttributeController controller = attributeLoader.getController();
        controller.setMainApp(this);
        controller.setCar(car);

        // Отображаем диалоговое окно и ждём, пока пользователь его не закроет
        dialogStage.showAndWait();
    }

    public void showResult() {
        AnchorPane resultLoader = (AnchorPane) this.resultLoader.getRoot();
        rootLayout.setCenter(resultLoader);
    }

    public void initCars() {
        if (cars.size() == 0) {
            try {
                RestTemplate restTemplate = new RestTemplate();
                String url = "http://localhost:8080/rest/cars";
                ObjectMapper objectMapper = new ObjectMapper();
                String json = restTemplate.getForEntity(url, String.class).getBody();
                List<Car> carsList = objectMapper.readValue(json,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Car.class));
                cars.addAll(carsList);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ResourceAccessException e) {
                showMessage();
            }
        }
    }

    private void initAttributes() {
        if (attributes.size() == 0) {
            try {
                RestTemplate restTemplate = new RestTemplate();
                String url = "http://localhost:8080/rest/attributes";
                ObjectMapper objectMapper = new ObjectMapper();
                String json = restTemplate.getForEntity(url, String.class).getBody();
                List<Attribute> attributeList = objectMapper.readValue(json,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Attribute.class));
                attributes.addAll(attributeList);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ResourceAccessException e) {
                showMessage();
            }
        }
    }
    private void showMessage(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.initOwner(getPrimaryStage());
        alert.setTitle("Нет соединения с сервером");
        alert.setContentText("Внимание!Ошибка соединения с сервером!");
        alert.showAndWait();
        showLogin();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public ObservableList<Car> getCars() {
        initCars();
        return cars;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ObservableList<Attribute> getAttributes() {
        initAttributes();
        return attributes;
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

    public void showCreditHistory() {
        if (user == null)
            showLogin();
        else {
            currentPage = CurrentPage.HISTORY;
            AnchorPane creditPage = (AnchorPane) creditHistoryLoader.getRoot();
            rootLayout.setCenter(creditPage);
            HistoryCredit controller = creditHistoryLoader.getController();
            controller.setMainApp(this);
        }
    }
}
