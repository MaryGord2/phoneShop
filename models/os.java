package ru.specialist.demo.models;

import javax.persistence.*;

@Entity
public class os {


    public Long osId;

    public String nameOs;

    public os(String nameOs) {
        super();
        this.nameOs = nameOs;
    }

    public os() {
    }

    @Id
    @Column(name = "osId", unique = true, nullable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long getId() {
        return osId;
    }

    public void setId(Long id) {
        this.osId = id;
    }

    public String getName() {
        return nameOs;
    }

    public void setName(String nameOs) {
        this.nameOs = nameOs;
    }
}
