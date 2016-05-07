package ru.kpfu.itis.khakov.forms;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Rus on 25.04.2016.
 */
public class RegistrationForm {

    @NotEmpty(message = "Поле обязательно для заполнения")
    @Size(max = 20, message = "не больше 20 символов")
    private String firstName;

    @NotEmpty(message = "Поле обязательно для заполнения")
    @Size(max = 20, message = "не больше 20 символов")
    private String lastName;

    @NotEmpty(message = "Поле обязательно для заполнения")
    @Size(max = 20, message = "не больше 20 символов")
    @Email
    private String email;

    @Size(min = 3, max = 13, message = "Введите верный номер телефона")
    @Pattern(regexp = "(\\+7|8)(\\d{10})", message = "неверный номер телефона")
    private String phone;

    @Size(min=6, max=20, message="Пароль должен быть от 6 до 20 символов")
    private String password;

    @Size(min=6, max=20, message="Пароль должен быть от 6 до 20 символов")
    private String confirmPassword;

    public RegistrationForm() {
    }


    public RegistrationForm(String firstName, String lastName, String email, String password, String confirmPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
//        this.phone = phone;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "RegistrationFormBean{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}