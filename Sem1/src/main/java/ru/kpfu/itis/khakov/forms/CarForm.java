package ru.kpfu.itis.khakov.forms;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.*;

/**
 * Created by Rus on 05.05.2016.
 */
public class CarForm {
    @NotEmpty(message = "Поле обязательно для заполнения")
    @Size(max = 50, message = "не больше 50 символов")
    private String manufacture;
    @NotEmpty(message = "Поле обязательно для заполнения")
    @Size(max = 50, message = "не больше 50 символов")
    private String model;
    @NotEmpty(message = "Поле обязательно для заполнения")
    @Size(max = 50, message = "не больше 50 символов")
    private String kof;
    @NotNull(message = "поле обязательно для заполнения")
    @Min(value = 1000000, message = "авто должно стоить больше 1 млн. рублей")
    @Max(value = 20000000, message = "авто не может стоить больше 20 млн. рублей")
    private Integer price;
    public CarForm(){};

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getKof() {
        return kof;
    }

    public void setKof(String kof) {
        this.kof = kof;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
