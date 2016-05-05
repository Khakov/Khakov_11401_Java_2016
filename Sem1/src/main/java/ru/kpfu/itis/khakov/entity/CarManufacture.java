package ru.kpfu.itis.khakov.entity;

import javax.persistence.*;

/**
 * Created by Rus on 17.04.2016.
 */
@Entity
@Table(name = "car_manufactures")
public class CarManufacture {
    private Long id;
    private String manufacture;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_manufactures_id_seq")
    @SequenceGenerator(name="car_manufactures_id_seq", sequenceName="car_manufactures_id_seq", allocationSize = 1)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "manufacture")
    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarManufacture that = (CarManufacture) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (manufacture != null ? !manufacture.equals(that.manufacture) : that.manufacture != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (manufacture != null ? manufacture.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CarManufacture{" +
                "id=" + id +
                ", manufacture='" + manufacture + '\'' +
                '}';
    }
}
