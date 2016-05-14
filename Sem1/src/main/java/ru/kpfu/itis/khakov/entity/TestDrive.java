package ru.kpfu.itis.khakov.entity;

import javax.persistence.*;

/**
 * Created by Rus on 04.05.2016.
 */
@Entity
@Table(name = "test_drive")
public class TestDrive {
    private Long id;
    private User user;
    private String number;
    private String date;
    private String name;
    private Status status;
    private Car car;

    public TestDrive() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_drive_id_seq")
    @SequenceGenerator(name = "test_drive_id_seq", sequenceName = "test_drive_id_seq", allocationSize = 1)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    public Car getCar() {
        return car;
    }

    @Column(name = "number")
    public String getNumber() {
        return number;
    }

    @Column(name = "date")
    public String getDate() {
        return date;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    public Status getStatus() {
        return status;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setStatus(Status status) {
        this.status = status;
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

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestDrive drive = (TestDrive) o;

        if (id != null ? !id.equals(drive.id) : drive.id != null) return false;
        if (user != null ? !user.equals(drive.user) : drive.user != null) return false;
        if (number != null ? !number.equals(drive.number) : drive.number != null) return false;
        if (date != null ? !date.equals(drive.date) : drive.date != null) return false;
        if (name != null ? !name.equals(drive.name) : drive.name != null) return false;
        if (status != null ? !status.equals(drive.status) : drive.status != null) return false;
        return car != null ? car.equals(drive.car) : drive.car == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (car != null ? car.hashCode() : 0);
        return result;
    }
}
