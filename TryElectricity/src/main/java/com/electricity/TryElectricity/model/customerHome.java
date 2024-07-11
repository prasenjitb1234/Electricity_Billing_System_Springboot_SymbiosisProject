package com.electricity.TryElectricity.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class customerHome {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO.IDENTITY)
	private int id;
	@NotBlank(message="username can't be empty")
	private String username;
	@NotBlank(message="password can't be empty")
	@Size(min=5,max=12,message="password should have 5 to 12 ")
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "customerHome [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	public customerHome(int id, @NotBlank(message = "username can't be empty") String username,
			@NotBlank(message = "password can't be empty") @Size(min = 5, max = 12, message = "password should have 5 to 12 ") String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public customerHome() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
