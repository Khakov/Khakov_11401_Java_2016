package ru.kpfu.itis.khakov.forms;

import javax.validation.constraints.NotNull;

/**
 * Created by Rus on 07.05.2016.
 */
public class ColorForm {
    @NotNull(message = "поле обязательно для заполнения")
    private String colorRu;
    @NotNull(message = "поле обязательно для заполнения")
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
