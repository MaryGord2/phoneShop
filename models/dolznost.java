package ru.specialist.demo.models;

import javax.persistence.*;

@Entity
public class dolznost {


    public Long dolznostId;

    public String nameDolznost;

    public dolznost(String nameDolznost) {
        super();
        this.nameDolznost = nameDolznost;
    }

    public dolznost() {
    }

    @Id
    @Column(name = "dolznostId", unique = true, nullable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long getId() {
        return dolznostId;
    }

    public void setId(Long id) {
        this.dolznostId = id;
    }

    public String getName() {
        return nameDolznost;
    }

    public void setName(String nameDolznost) {
        this.nameDolznost = nameDolznost;
    }
}
