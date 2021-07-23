package ru.specialist.demo.models;

import javax.persistence.*;

@Entity
public class formFactor {


    public Long formFactorId;

    public String nameFormFactor;

    public formFactor(String nameFormFactor) {
        super();
        this.nameFormFactor = nameFormFactor;
    }

    public formFactor() {
    }

    @Id
    @Column(name = "formFactorId", unique = true, nullable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long getId() {
        return formFactorId;
    }

    public void setId(Long id) {
        this.formFactorId = id;
    }

    public String getName() {
        return nameFormFactor;
    }

    public void setName(String nameFormFactor) {
        this.nameFormFactor = nameFormFactor;
    }
}
