package ru.specialist.demo.models;

import javax.persistence.*;

@Entity
public class producer {


	public Long producerId;

	public String nameProducer;

	public country countryProducer;

	public producer(String nameProducer, country country) {
		super();
		this.nameProducer = nameProducer;
		this.countryProducer = country;
	}

	public producer() {
	}

	@Id
	@Column(name = "producerId", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return producerId;
	}

	public void setId(Long producerId) {
		this.producerId = producerId;
	}

	public String getName() {
		return nameProducer;
	}

	public void setName(String nameProducer) {
		this.nameProducer = nameProducer;
	}

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="countryProducer", nullable=false, insertable=true, updatable=true, referencedColumnName = "countryId")
	public country getCountryProducer() {
		return countryProducer;
	}

	public void setCountryProducer(country countryProducer) {
		this.countryProducer = countryProducer;
	}
}
