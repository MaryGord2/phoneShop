package ru.specialist.demo.models;

import javax.persistence.*;

@Entity
public class typeDispl {


    public Long typeDisplId;

    public String nametypeDispl;

    public typeDispl(String nametypeDispl) {
        super();
        this.nametypeDispl = nametypeDispl;
    }

    public typeDispl() {
    }

    @Id
    @Column(name = "typeDisplId", unique = true, nullable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long getId() {
        return typeDisplId;
    }
    public void setId(Long typeDisplId) {
        this.typeDisplId = typeDisplId;
    }

    public String getName() {
        return nametypeDispl;
    }

    public void setName(String nametypeDispl) {
        this.nametypeDispl = nametypeDispl;
    }
}
