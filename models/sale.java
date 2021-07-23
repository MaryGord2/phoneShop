package ru.specialist.demo.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class sale {


	public Long saleId;

	public LocalDateTime dateSale;
	public client clientSale;
	public employee employeeSale;
	public Double sumSale;

		public sale(client clientSale, employee employeeSale, Double sumSale) {
		super();
		this.clientSale = clientSale;
		this.employeeSale = employeeSale;
		this.sumSale = sumSale;
		this.dateSale = LocalDateTime.now();
	}

	public sale() {
	}

	@Id
	@Column(name = "saleId", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return saleId;
	}
	public void setId(Long id) {
		this.saleId = id;
	}

	public LocalDateTime getDateSale() {
		return dateSale;
	}
	public void setDateSale(LocalDateTime dateSale) { this.dateSale = dateSale; }

	public Double getSumSale() {
		return sumSale;
	}
	public void setSumSale(Double sumSale) {
		this.sumSale = sumSale;
	}

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="employeeSale", nullable=false, insertable=true, updatable=true, referencedColumnName = "employeeId")
	public employee getEmployeeSale() {
		return employeeSale;
	}
	public void setEmployeeSale(employee employeeSale) {
		this.employeeSale = employeeSale;
	}


	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="clientSale", nullable=false, insertable=true, updatable=true, referencedColumnName = "clientId")
	public client getClientSale() {
		return clientSale;
	}
	public void setClientSale(client clientSale) {
		this.clientSale = clientSale;
	}
}
