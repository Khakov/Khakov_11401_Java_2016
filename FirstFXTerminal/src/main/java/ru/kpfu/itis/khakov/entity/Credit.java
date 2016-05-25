package ru.kpfu.itis.khakov.entity;

import java.sql.Date;

/**
 * Created by Rus on 03.05.2016.
 */
public class Credit {
    private Long id;
    private User user;
    private String name;
    private String number;
    private Date date;
    private Car car;
    private Status status;
    public Credit(){}

    public Long getId() {
        return id;
    }


    public User getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public Date getDate() {
        return date;
    }


    public Car getCar() {
        return car;
    }


    public Status getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
