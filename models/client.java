package ru.specialist.demo.models;

import javax.persistence.*;

@Entity
public class client{


	public Long clientId;
	
	public String name, firstname, lastname, pasport, address, numberOfPhone;

	public client(String name, String firstname, String numberOfPhone, String lastname, String pasport, String address) {
		super();
		this.name = name;
		this.firstname = firstname;
		this.numberOfPhone = numberOfPhone;
		this.lastname = lastname;
		this.pasport = pasport;
		this.address = address;
	}

	public client() {
	}

	@Id
	@Column(name = "clientId", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return clientId;
	}

	public void setId(Long id) {
		this.clientId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getNumberOfPhone() {
		return numberOfPhone;
	}

	public void setNumberOfPhone(String numberOfPhone) {
		this.numberOfPhone = numberOfPhone;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPasport() {
		return pasport;
	}

	public void setPasport(String pasport) {
		this.pasport = pasport;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
