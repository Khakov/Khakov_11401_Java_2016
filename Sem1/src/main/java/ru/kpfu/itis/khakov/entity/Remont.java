package ru.kpfu.itis.khakov.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Rus on 04.05.2016.
 */
@Entity
@Table(name = "users_applications")
public class Remont {
    private Long id;
    private User user;
    private String number;
    private String description;
    private Date date;
    private String name;
    private Type type;
    private Result result;
    private Car car;

    public Remont() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_applications_id_seq")
    @SequenceGenerator(name = "users_applications_id_seq", sequenceName = "users_applications_id_seq", allocationSize = 1)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    public Car getCar() {
        return car;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    @Column(name = "phone_number")
    public String getNumber() {
        return number;
    }

    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    public Type getType() {
        return type;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    @ManyToOne
    @JoinColumn(name = "result", referencedColumnName = "id")
    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
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
}
