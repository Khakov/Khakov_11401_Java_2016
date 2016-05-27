package ru.kpfu.itis.khakov.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by Rus on 05.05.2016.
 */
@Entity
@Table(name = "my_cars")
public class MyCar {
    private Long id;
    private Color color;
    @JsonIgnore
    private User user;
    private Car car;
    @JsonManagedReference
    private List<Attribute> attributes;
    private Date date;
    private Boolean status;

    public MyCar() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_cars_id_seq")
    @SequenceGenerator(name = "my_cars_id_seq", sequenceName = "my_cars_id_seq", allocationSize = 1)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "color_id", referencedColumnName = "id")
    public Color getColor() {
        return color;
    }

    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    @Column(name = "status")
    public Boolean getStatus() {
        return status;
    }

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    public Car getCar() {
        return car;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "car_atributes", joinColumns = @JoinColumn(name = "cars_id"),
            inverseJoinColumns = @JoinColumn(name = "attributes_id"))
    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }
}
