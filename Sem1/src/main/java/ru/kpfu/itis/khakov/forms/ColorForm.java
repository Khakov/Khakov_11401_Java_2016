package ru.kpfu.itis.khakov.forms;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Rus on 07.05.2016.
 */
public class ColorForm {
    @NotEmpty(message = "поле обязательно для заполнения")
    @Size(max = 20, message = "не больше 20 символов")
    private String colorRu;
    @NotEmpty(message = "поле обязательно для заполнения")
    @Size(max = 20, message = "не больше 20 символов")
    private String colorEn;
    public ColorForm(){}

    public String getColorRu() {
        return colorRu;
    }

    public void setColorRu(String colorRu) {
        this.colorRu = colorRu;
    }

    public String getColorEn() {
        return colorEn;
    }

    public void setColorEn(String colorEn) {
        this.colorEn = colorEn;
    }
}
