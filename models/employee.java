package ru.specialist.demo.models;

import javax.persistence.*;

@Entity
public class employee {


	public Long employeeId;

	public String name, firstname, lastname, address, numberOfPhone, login, password;

	public dolznost dolznnostEmployee;

	public employee(String name, String firstname, String numberOfPhone, String lastname, String address, String login, String password, dolznost dolznost) {
		super();
		this.name = name;
		this.firstname = firstname;
		this.numberOfPhone = numberOfPhone;
		this.lastname = lastname;
		this.login = login;
		this.address = address;
		this.password = password;
		this.dolznnostEmployee = dolznost;
	}

	public employee() {
	}

	@Id
	@Column(name = "employeeId", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return employeeId;
	}
	public void setId(Long employeeId) {
		this.employeeId = employeeId;
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

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() { return password; }
	public void setPassword(String password) {
		this.password = password;
	}

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="dolznnostEmployee", nullable=false, insertable=true, updatable=true, referencedColumnName = "dolznostId")
	public dolznost getDolzn() { return dolznnostEmployee; }
	public void setDolzn(dolznost dolznosti) {
		this.dolznnostEmployee = dolznosti;
	}
}
