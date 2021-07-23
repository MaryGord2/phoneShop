package ru.specialist.demo.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class delivery {

	private Long idDelivery;

	private provider providerIds;

	private Double sumDelivery;

	private String contractNumber;

	private LocalDateTime dateDelivery;

	public delivery(provider provider, Double sumDelivery, String contractNumber) {
		super();
		this.providerIds = provider;
		this.sumDelivery = sumDelivery;
		this.contractNumber = contractNumber;
		this.dateDelivery = LocalDateTime.now();
	}

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="providerIds", nullable=false, insertable=true, updatable=true, referencedColumnName = "providerId")
	public provider getProviderIds() {
		return providerIds;
	}

	public void setProviderIds(provider providerIds) {
		this.providerIds = providerIds;
	}

	@Id
	@Column(name = "idDelivery", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getDeliveryId() {
		return idDelivery;
	}
	public void setDeliveryId(Long idDelivery) {
		this.idDelivery = idDelivery;
	}


	public Double getSumDelivery() {
		return sumDelivery;
	}
	public void setSumDelivery(Double sumDelivery) {
		this.sumDelivery = sumDelivery;
	}


	public String getContractNumber() {
		return contractNumber;
	}
	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	public LocalDateTime getDateDelivery() {
		return dateDelivery;
	}

	public delivery() {
		super();
	}

	public void setDateDelivery(LocalDateTime dateDelivery) {
		this.dateDelivery = dateDelivery;
	}
}
