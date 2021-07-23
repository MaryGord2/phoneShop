package ru.specialist.demo.models;

import javax.persistence.*;

@Entity
public class sostavDelivery {


    public Long id;
    public delivery deliveriesId;
    public phone phoneDeliveryId;
    public int countPhoneDelivery;

    public sostavDelivery(delivery deliveriesId, phone phoneDeliveryId, int countPhoneDelivery) {
        super();
        this.deliveriesId = deliveriesId;
        this.phoneDeliveryId = phoneDeliveryId;
        this.countPhoneDelivery = countPhoneDelivery;
    }

    public sostavDelivery() {
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="deliveriesId", nullable=false, insertable=true, updatable=true, referencedColumnName = "idDelivery")
    public delivery getDeliveriesId() {
        return deliveriesId;
    }
    public void setDeliveriesId(delivery deliveriesId) {
        this.deliveriesId = deliveriesId;
    }

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="phoneDeliveryId", nullable=false, insertable=true, updatable=true, referencedColumnName = "phoneId")
    public phone getPhoneDeliveryId() {
        return phoneDeliveryId;
    }
    public void setPhoneDeliveryId(phone phoneDeliveryId) {
        this.phoneDeliveryId = phoneDeliveryId;
    }

    public int getCountPhoneDelivery() {
        return countPhoneDelivery;
    }
    public void setCountPhoneDelivery(int countPhoneDelivery) {
        this.countPhoneDelivery = countPhoneDelivery;
    }
}
