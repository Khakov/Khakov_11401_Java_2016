package ru.kpfu.itis.khakov.entity;

import javax.persistence.*;

/**
 * Created by Rus on 04.05.2016.
 */
@Entity
@Table(name = "result")
public class Result {
    private Long id;
    private String result;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "result_id_seq")
    @SequenceGenerator(name = "result_id_seq", sequenceName = "result_id_seq", allocationSize = 1)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "result")
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
