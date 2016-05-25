package ru.kpfu.itis.khakov.entity;

import java.sql.Date;
import java.util.List;

/**
 * Created by Rus on 05.05.2016.
 */

public class MyCar {
    private Long id;
    private Color color;
    private User user;
    private Car car;
    private List<Attribute> attributes;
    private Date date;
    private Boolean status;

    public MyCar() {
    }

    public Long getId() {
        return id;
    }

    public Color getColor() {
        return color;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public User getUser() {
        return user;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    public Boolean getStatus() {
        return status;
    }

    public Car getCar() {
        return car;
    }

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
