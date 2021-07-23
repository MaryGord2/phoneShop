package ru.specialist.demo.models;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class letter {

	
	private Long id;
	
	private client senderId;
	
	private String theme;
	
	private String address;
	
private String text;
	
	private LocalDateTime dateSend;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="senderId", nullable=false, insertable=true, updatable=true, referencedColumnName = "clientId")
	public client getSenderId() {
		return senderId;
	}

	public void setSenderId(client senderId) {
		this.senderId = senderId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public letter(client sender, String theme, String text, String address) {
		super();
		this.senderId = sender;
		this.theme = theme;
		this.text = text;
		this.address = address;
		this.dateSend = LocalDateTime.now();;
	}

	public LocalDateTime getDateSend() {
		return dateSend;
	}

	public letter() {
		super();
	}

	public void setDateSend(LocalDateTime dateSend) {
		this.dateSend = dateSend;
	}
}
