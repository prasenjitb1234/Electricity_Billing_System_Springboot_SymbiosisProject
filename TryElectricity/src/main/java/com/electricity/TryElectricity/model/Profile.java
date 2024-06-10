package com.electricity.TryElectricity.model;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Profile {
	@Id
	private int id;
	@Lob
	@Column(length=1000000000)
	private byte[] image;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Profile [id=" + id + ", image=" + Arrays.toString(image) + "]";
	}
	public Profile(int id, byte[] image) {
		super();
		this.id = id;
		this.image = image;
	}
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
