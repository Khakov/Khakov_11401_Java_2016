package ru.kpfu.itis.khakov.forms;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by Rus on 07.05.2016.
 */
public class TypeForm {
    @NotEmpty(message = "поле обязательно для заполнения")
    @Size(max = 20, message = "не больше 20 символов")
    private String type;

    public TypeForm() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
