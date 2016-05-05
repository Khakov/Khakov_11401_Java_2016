package ru.kpfu.itis.khakov.entity;

import javax.persistence.*;

/**
 * Created by Rus on 04.05.2016.
 */
@Entity
@Table(name = "types")
public class Type {
    private Long id;
    private String type;

    public Type() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "types_id_seq")
    @SequenceGenerator(name = "types_id_seq", sequenceName = "types_id_seq", allocationSize = 1)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
