package ru.kpfu.itis.khakov;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class ConfigurationControllers {

	@Bean(name = "testLoader")
    public FXMLLoader getTesttLoader() {
        return loadView("Test_Drive.fxml");
    }
   @Bean(name = "catalogLoader")
    public FXMLLoader getCatalogLoader() {
        return loadView("Catalog.fxml");
    }
    @Bean(name = "mainLoader")
    public FXMLLoader getMenuLoader() {
        return loadView("Main.fxml");
    }
   @Bean(name = "loginLoader")
    public FXMLLoader getLoginLoader() {
        return loadView("Login.fxml");
    }
	@Bean(name = "creditLoader")
    public FXMLLoader getCreditLoader() {
        return loadView("Credit.fxml");
    }
	@Bean(name = "attributeLoader")
    public FXMLLoader getAttributeLoader() {
        return loadView("Attributes.fxml");
    }
    protected FXMLLoader loadView(String url) {
        InputStream fxmlStream = null;
        try {
            fxmlStream = getClass().getClassLoader().getResourceAsStream(url);
            FXMLLoader loader = new FXMLLoader();
            loader.load(fxmlStream);
            System.out.println(loader.getRoot().toString());
            return loader;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fxmlStream != null) {
                try {
                    fxmlStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
