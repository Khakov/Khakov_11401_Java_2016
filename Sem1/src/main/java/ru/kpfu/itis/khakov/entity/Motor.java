package ru.kpfu.itis.khakov.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Rus on 17.04.2016.
 */
@Entity
@Table(name = "motor")
public class Motor {
    private Long id;
    private String type;
    private int horsepower;
    private int consumption;
    @JsonBackReference
    private List<Model> models;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "motor_id_seq")
    @SequenceGenerator(name = "motor_id_seq", sequenceName = "motor_id_seq", allocationSize = 1)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "horsepower")
    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    @Basic
    @Column(name = "consumption")
    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }

    @OneToMany(targetEntity = Model.class, mappedBy = "motor", fetch = FetchType.EAGER)
    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Motor that = (Motor) o;

        if (horsepower != that.horsepower) return false;
        if (consumption != that.consumption) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + horsepower;
        result = 31 * result + consumption;
        return result;
    }
}
