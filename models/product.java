package ru.specialist.demo.models;

import javax.persistence.*;

@Entity
public class product {

    public Long productId;
    public String name;
    public producer producerPhone;
    public Double cost, costbuy;
    public int countInMagazine;
    public String color, razmer, mass;

    public product(String name, producer producer, Double cost, Double costbuy, int countInMagazine, String color, String razmer, String mass) {
        super();
        this.name = name;
    }

    public product() {
    }

    @Id
    @Column(name = "productId", unique = true, nullable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long getId() {
        return productId;
    }
    public void setId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }
    public void setName(String model) {
        this.name = name;
    }
}
