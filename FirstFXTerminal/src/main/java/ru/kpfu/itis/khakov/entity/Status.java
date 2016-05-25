package ru.kpfu.itis.khakov.entity;


/**
 * Created by Rus on 03.05.2016.
 */
public class Status {
    private Long id;
    private String status;

    public Status(){}

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
