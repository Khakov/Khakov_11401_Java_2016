package ru.kpfu.itis.khakov.forms;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Rus on 07.05.2016.
 */
public class AttributeForm {
    @NotEmpty(message = "Заполните поле")
    @Size(max = 50, message = "не больше 50 символов")
    private String attribute;
    @NotEmpty(message = "Заполните поле")
    @Size(max = 250, message = "не больше 250 символов")
    private String description;
    @Min(value = 1000, message = "опция не может стоить меньше 1000")
    @Max(value = 20000000, message = "опция не может стоить больше 20 000 000")
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
