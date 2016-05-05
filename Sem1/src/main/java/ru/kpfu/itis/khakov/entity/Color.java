package ru.kpfu.itis.khakov.entity;

import javax.persistence.*;

/**
 * Created by Rus on 17.04.2016.
 */
@Entity
@Table(name = "color")
public class Color {
    private Long id;
    private String colorRu;
    private String colorEn;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "color_ru")
    public String getColorRu() {
        return colorRu;
    }

    public void setColorRu(String colorRu) {
        this.colorRu = colorRu;
    }

    @Basic
    @Column(name = "color_en")
    public String getColorEn() {
        return colorEn;
    }

    public void setColorEn(String colorEn) {
        this.colorEn = colorEn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Color that = (Color) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (colorRu != null ? !colorRu.equals(that.colorRu) : that.colorRu != null) return false;
        if (colorEn != null ? !colorEn.equals(that.colorEn) : that.colorEn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (colorRu != null ? colorRu.hashCode() : 0);
        result = 31 * result + (colorEn != null ? colorEn.hashCode() : 0);
        return result;
    }
}
