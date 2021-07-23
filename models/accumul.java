package ru.specialist.demo.models;

import javax.persistence.*;

@Entity
public class accumul {


    public Long accumulId;

    public String nameAccum;

    public accumul(String nameAccum) {
        super();
        this.nameAccum = nameAccum;
    }

    public accumul() {
    }

    @Id
    @Column(name = "accumulId", unique = true, nullable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long getId() {
        return accumulId;
    }

    public void setId(Long id) {
        this.accumulId = id;
    }

    public String getName() {
        return nameAccum;
    }

    public void setName(String name) {
        this.nameAccum = name;
    }
}
