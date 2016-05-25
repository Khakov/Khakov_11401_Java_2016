package ru.kpfu.itis.khakov;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class ConfigurationControllers {

   
    @Bean(name = "mainLoader")
    public FXMLLoader getMenuLoader() {
        return loadView("Main.fxml");
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
