package ru.specialist.demo.models;

import javax.persistence.*;

@Entity
public class sostavSales {

    public Long id;

    public sale salesId;
    public phone phoneSaleId;
    public int countPhoneSale;

    public sostavSales(sale salesId, phone phoneSaleId, int countPhoneSale) {
        super();
        this.salesId = salesId;
        this.phoneSaleId = phoneSaleId;
        this.countPhoneSale = countPhoneSale;
    }

    public sostavSales() {
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
    @JoinColumn(name="salesId", nullable=false, insertable=true, updatable=true, referencedColumnName = "saleId")
    public sale getSaleId() {
        return salesId;
    }
    public void setSaleId(sale saleId) {
        this.salesId = saleId;
    }

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="phoneSaleId", nullable=false, insertable=true, updatable=true, referencedColumnName = "phoneId")
    public phone getPhoneSaleId() {
        return phoneSaleId;
    }
    public void setPhoneSaleId(phone phoneSaleId) {
        this.phoneSaleId = phoneSaleId;
    }

    public int getCountPhoneSale() {
        return countPhoneSale;
    }
    public void setCountPhoneSale(int countPhoneSale) {
        this.countPhoneSale = countPhoneSale;
    }
}
