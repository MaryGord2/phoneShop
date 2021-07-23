package ru.specialist.demo.models;

import javax.persistence.*;

@Entity
public class provider {


	public Long providerId;

	public String nameProvider, contact, address, numberOfPhone, inn, kpp, schet;
	public country countryIds;

	public provider(String nameProvider, String contact, String address, String numberOfPhone, String inn, String kpp, String schet, country country) {
		super();
		this.nameProvider = nameProvider;
		this.contact = contact;
		this.numberOfPhone = numberOfPhone;
		this.inn = inn;
		this.kpp = kpp;
		this.address = address;
		this.schet = schet;
		this.countryIds = country;
	}

	public provider() {
	}

	@Id
	@Column(name = "providerId", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return providerId;
	}

	public void setId(Long id) {
		this.providerId = id;
	}

	public String getName() {
		return nameProvider;
	}

	public void setName(String nameProvider) {
		this.nameProvider = nameProvider;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getNumberOfPhone() {
		return numberOfPhone;
	}

	public void setNumberOfPhone(String numberOfPhone) {
		this.numberOfPhone = numberOfPhone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getInn() {
		return inn;
	}

	public void setInn(String inn) {
		this.inn = inn;
	}

	public String getKpp() {
		return kpp;
	}

	public void setKpp(String kpp) {
		this.kpp = kpp;
	}

	public String getSchet() {
		return schet;
	}

	public void setSchet(String schet) {
		this.schet = schet;
	}

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="countryIds", nullable=false, insertable=true, updatable=true, referencedColumnName = "countryId")
	public country getCountryIds() {
		return countryIds;
	}

	public void setCountryIds(country countryIds) {
		this.countryIds = countryIds;
	}
}
