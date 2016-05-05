package ru.kpfu.itis.khakov.forms;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

/**
 * Created by Rus on 04.05.2016.
 */
public class RemontForm {
    @NotEmpty(message = "Поле обязательно для заполнения")
    private String firstName;
    @NotEmpty(message = "Поле обязательно для заполнения")
    @Pattern(regexp = "(\\+7|8)(\\d{10})", message = "неправильно введен номер")
    private String number;
    @NotEmpty(message = "Поле обязательно для заполнения")
    private String id;
    @NotEmpty(message = "Заполните описание проблемы")
    private String description;
    @NotEmpty(message = "Поле обязательно для заполнения")
    private String type;
    public RemontForm() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
