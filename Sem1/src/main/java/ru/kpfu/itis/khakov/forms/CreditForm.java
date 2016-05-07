package ru.kpfu.itis.khakov.forms;

import org.hibernate.validator.constraints.NotEmpty;
import ru.kpfu.itis.khakov.entity.Car;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Rus on 03.05.2016.
 */
public class CreditForm {
    @NotEmpty(message = "Поле обязательно для заполнения")
    @Size(max = 20, message = "не больше 20 символов")
    private String firstName;
    @NotEmpty(message = "Поле обязательно для заполнения")
    @Size(min = 3, max = 13, message = "Введите верный номер телефона")
    @Pattern(regexp = "(\\+7|8)(\\d{10})", message = "неправильно введен номер")
    private String number;
    @NotEmpty(message = "Поле обязательно для заполнения")
    @Size(max = 20, message = "не больше 20 символов")
    private String id;

    public CreditForm() {
    }
    public CreditForm(String firstName, String number){
        this.firstName = firstName;
        this.number = number;
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
