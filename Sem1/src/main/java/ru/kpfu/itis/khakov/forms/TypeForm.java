package ru.kpfu.itis.khakov.forms;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Rus on 07.05.2016.
 */
public class TypeForm {
    @NotEmpty(message = "поле обязательно для заполнения")
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
