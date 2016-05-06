package ru.kpfu.itis.khakov.forms;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Rus on 07.05.2016.
 */
public class AttributeForm {
    @NotEmpty(message = "Заполните поле")
    private String attribute;
    @NotEmpty(message = "Заполните поле")
    private String description;
    @Min(value = 1000, message = "опция не может стоить меньше 1000")
    private Integer price;

    public AttributeForm() {
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
