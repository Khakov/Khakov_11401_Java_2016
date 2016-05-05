package ru.kpfu.itis.khakov.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Rus on 03.05.2016.
 */
@Entity
@Table(name = "credit")
public class Credit {
    private Long id;
    private User user;
    private String name;
    private String number;
    private Date date;
    private Car car;
    private Status status;
    public Credit(){}
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "credit_id_seq")
    @SequenceGenerator(name = "credit_id_seq", sequenceName = "credit_id_seq", allocationSize = 1)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "number")
    public String getNumber() {
        return number;
    }

    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    public Car getCar() {
        return car;
    }

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
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
