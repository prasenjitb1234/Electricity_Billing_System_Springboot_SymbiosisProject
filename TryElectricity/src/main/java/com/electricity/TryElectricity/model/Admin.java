package com.electricity.TryElectricity.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO.IDENTITY)
	private int id;
	@NotBlank(message="Admin name can't be empty")
	@Pattern(regexp="^[a-zA-z]+$",message="only letters allowed")
	@Size(min=2,max=12,message="Admin name should have 3 to 12 letters")
	private String name;
	@NotBlank(message="username can't be empty")
	private String username;
	@NotBlank(message="password can't be empty")
	@Size(min=5,max=12,message="password should have 8 to 12 ")
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		return "Admin [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + "]";
	}
	public Admin(int id,
			@NotBlank(message = "Admin name can't be empty") @Pattern(regexp = "^[a-zA-z]+$", message = "only letters allowed") @Size(min = 2, max = 12, message = "Admin name should have 3 to 12 letters") String name,
			@NotBlank(message = "username can't be empty") String username,
			@NotBlank(message = "password can't be empty") @Size(min = 5, max = 12, message = "password should have 8 to 12 ") String password) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
