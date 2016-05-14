package ru.kpfu.itis.khakov.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Rus on 17.04.2016.
 */
@Entity
@Table(name = "attributes")
public class Attribute {
    private Long id;
    private String name;
    private String description;
    private int price;
    private List<MyCar> cars;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attributes_id_seq")
    @SequenceGenerator(name = "attributes_id_seq", sequenceName = "attributes_id_seq", allocationSize = 1)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy="attributes", cascade = CascadeType.ALL)
    public List<MyCar> getCars() {
        return cars;
    }

    public void setCars(List<MyCar> cars) {
        this.cars = cars;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
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

        Attribute that = (Attribute) o;

        if (price != that.price) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }
}