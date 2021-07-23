package ru.specialist.demo.models;

import javax.persistence.*;

@Entity
public class phone {


	public Long phoneId;

	public producer producerPhone;
	public formFactor formFactorPhone;
	public accumul typeAccum;
	public os operSys;
	public typeDispl typeDisplay;

	public Boolean isSensor;
	public Double cost, costbuy;
	public int countInMagazine;
	public String model, color, cameraRaz, accumVolume, memoryVp, memoryOp, diagonalDispl, razmer, mass;

	public phone(String model, String color, String cameraRaz, String accumVolume,
				 String memoryVp, String memoryOp, String diagonalDispl, String razmer, String mass,
				 Double cost, Double costbuy, int countInMagazine, Boolean isSensor, typeDispl typeDisplay,
				 os operSys, accumul typeAccumul, formFactor formFactorPhone, producer producerPhone) {
		super();
		this.model = model;
		this.color = color;
		this.cameraRaz = cameraRaz;
		this.accumVolume = accumVolume;
		this.memoryVp = memoryVp;
		this.memoryOp = memoryOp;
		this.diagonalDispl = diagonalDispl;
		this.razmer = razmer;
		this.mass = mass;
		this.cost = cost;
		this.costbuy = costbuy;
		this.countInMagazine = countInMagazine;
		this.isSensor = isSensor;
		this.typeDisplay = typeDisplay;
		this.operSys = operSys;
		this.typeAccum = typeAccumul;
		this.formFactorPhone = formFactorPhone;
		this.producerPhone = producerPhone;
	}

	public phone() {
	}

	@Id
	@Column(name = "phoneId", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return phoneId;
	}
	public void setId(Long phoneId) {
		this.phoneId = phoneId;
	}

	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	public String getСameraRaz() {
		return cameraRaz;
	}
	public void setСameraRaz(String cameraRaz) {
		this.cameraRaz = cameraRaz;
	}

	public String getAccumVolume() {
		return accumVolume;
	}
	public void setAccumVolume(String accumVolume) {
		this.accumVolume = accumVolume;
	}

	public String getMemoryVp() {
		return memoryVp;
	}
	public void setMemoryVp(String memoryVp) {
		this.memoryVp = memoryVp;
	}

	public String getMemoryOp() {
		return memoryOp;
	}
	public void setMemoryOp(String memoryOp) {
		this.memoryOp = memoryOp;
	}

	public String getDiagonalDispl() {
		return diagonalDispl;
	}
	public void setDiagonalDispl(String diagonalDispl) {
		this.diagonalDispl = diagonalDispl;
	}

	public String getRazmer() {
		return razmer;
	}
	public void setRazmer(String razmer) {
		this.razmer = razmer;
	}

	public String getMass() {
		return mass;
	}
	public void setMass(String mass) {
		this.razmer = mass;
	}

	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Double getCostBuy() {
		return costbuy;
	}
	public void setCostBuy(Double costBuy) {
		this.costbuy = costBuy;
	}

	public int getCountInMagazine() { return countInMagazine; }
	public void setCountInMagazine(int countInMagazine) {
		this.countInMagazine = countInMagazine;
	}

	public Boolean getIsSensor() {
		return isSensor;
	}
	public void setIsSensor(Boolean isSensor) {
		this.isSensor = isSensor;
	}

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="typeDisplay", nullable=false, insertable=true, updatable=true, referencedColumnName = "typeDisplId")
	public typeDispl getTypeDisplay() {
		return typeDisplay;
	}
	public void setTypeDisplay(typeDispl typeDisplay) {
		this.typeDisplay = typeDisplay;
	}

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="operSys", nullable=false, insertable=true, updatable=true, referencedColumnName = "osId")
	public os getOs() {
		return operSys;
	}
	public void setOs(os operSys) {
		this.operSys = operSys;
	}

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="typeAccum", nullable=false, insertable=true, updatable=true, referencedColumnName = "accumulId")
	public accumul getAccumul() {
		return typeAccum;
	}
	public void setAccumul(accumul accumul) {
		this.typeAccum = accumul;
	}

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="formFactorPhone", nullable=false, insertable=true, updatable=true, referencedColumnName = "formFactorId")
	public formFactor getFormFactorPhone() {
		return formFactorPhone;
	}
	public void setFormFactorPhone(formFactor formFactor) {
		this.formFactorPhone = formFactor;
	}

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="producerPhone", nullable=false, insertable=true, updatable=true, referencedColumnName = "producerId")
	public producer getProducerPhone() {
		return producerPhone;
	}
	public void setProducerPhone(producer producer) {
		this.producerPhone = producer;
	}
}
