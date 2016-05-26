package ru.kpfu.itis.khakov.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

/**
 * Created by Rus on 17.04.2016.
 */
@Entity
@Table(name = "models")
public class Model {
    private Long id;
    private String model;
    @JsonManagedReference
    Motor motor;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "models_id_seq")
    @SequenceGenerator(name = "models_id_seq", sequenceName = "models_id_seq", allocationSize = 1)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @ManyToOne
    @JoinColumn(name = "motor", referencedColumnName = "id")
    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Model that = (Model) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        return result;
    }
}
