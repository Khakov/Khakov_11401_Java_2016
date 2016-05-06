package ru.kpfu.itis.khakov.entity;

import javax.persistence.*;

/**
 * Created by Rus on 06.05.2016.
 */
@Entity
@Table(name = "car_page")
public class Page {
    private Long id;
    private Car car;
    private String path;

    public Page() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_page_id_seq")
    @SequenceGenerator(name = "car_page_id_seq", sequenceName = "car_page_id_seq", allocationSize = 1)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    @Column(name = "path")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
