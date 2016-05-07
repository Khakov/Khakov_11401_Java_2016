package ru.kpfu.itis.khakov.forms;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Rus on 04.05.2016.
 */
public class TestDirveForm {
    @NotEmpty(message = "Поле обязательно для заполнения")
    @Size(max = 20, message = "не больше 20 символов")
    private String firstName;
    @NotEmpty(message = "Поле обязательно для заполнения")
    @Size(min = 3, max = 13, message = "Введите верный номер телефона")
    @Pattern(regexp = "(\\+7|8)(\\d{10})", message = "неправильно введен номер")
    private String number;
    @NotEmpty(message = "Поле обязательно для заполнения")
    @Size(max = 50, message = "не больше 50 символов")
    private String id;
    @Pattern(regexp = "(\\d{2})/(\\d{2})/(19|20)(\\d{2})", message = "неправильно введена дата")
    @Size(max = 20, message = "не больше 20 символов")
    private String date;

    public TestDirveForm() {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
