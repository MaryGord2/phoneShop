package ru.specialist.demo.models;

import javax.persistence.*;

@Entity
public class country {


    public Long countryId;

    public String countryName;

    public country(String countryName) {
        super();
        this.countryName = countryName;
    }

    public country() {
    }

    @Id
    @Column(name = "countryId", unique = true, nullable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long getId() {
        return countryId;
    }

    public void setId(Long id) {
        this.countryId = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
