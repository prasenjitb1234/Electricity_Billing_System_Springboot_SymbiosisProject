package com.electricity.TryElectricity.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Complaint {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String text;
	
	private String username;
	
	private String pincode;
	
	private String address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Complaint [id=" + id + ", text=" + text + ", username=" + username + ", pincode=" + pincode
				+ ", address=" + address + "]";
	}

	public Complaint(Long id, String text, String username, String pincode, String address) {
		super();
		this.id = id;
		this.text = text;
		this.username = username;
		this.pincode = pincode;
		this.address = address;
	}

	public Complaint() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
}
