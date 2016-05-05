package ru.kpfu.itis.khakov.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Rus on 17.04.2016.
 */
@Entity
@Table(name = "cars")
public class Car {
    private Long id;
    private Double kof;
    private CarManufacture manufacture;
    private Model model;
    private int price;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cars_id_seq")
    @SequenceGenerator(name = "cars_id_seq", sequenceName = "cars_id_seq", allocationSize = 1)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manufacture", referencedColumnName = "id")
    public CarManufacture getManufacture() {
        return manufacture;
    }

    public void setManufacture(CarManufacture manufacture) {
        this.manufacture = manufacture;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "model", referencedColumnName = "id")
    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    @Basic
    @Column(name = "kof")
    public Double getKof() {
        return kof;
    }

    public void setKof(Double kof) {
        this.kof = kof;
    }

    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (price != car.price) return false;
        if (id != null ? !id.equals(car.id) : car.id != null) return false;
        if (kof != null ? !kof.equals(car.kof) : car.kof != null) return false;
        if (manufacture != null ? !manufacture.equals(car.manufacture) : car.manufacture != null) return false;
        return model != null ? model.equals(car.model) : car.model == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (kof != null ? kof.hashCode() : 0);
        result = 31 * result + (manufacture != null ? manufacture.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", kof=" + kof +
                ", manufacture=" + manufacture +
                ", model=" + model +
                '}';
    }
}
