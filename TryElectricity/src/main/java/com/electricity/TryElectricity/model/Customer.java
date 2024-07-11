package com.electricity.TryElectricity.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO.IDENTITY)
	private int id;
	
	@NotBlank(message = "first name can't be empty")
	@Pattern(regexp = "^[a-zA-z]+$", message = "only letters allowed")
	@Size(min = 3, max = 12, message = "first name should have 3 to 12 letters")
	private String firstName;
	
	@NotBlank(message = "Last name can't be empty")
	@Pattern(regexp = "^[a-zA-z]+$", message = "only letters allowed")
	@Size(min = 3, max = 12, message = "Last name should have 3 to 12 letters")
	private String lastName;
	
	@NotBlank(message = "address can't be empty")
	private String address;
	
	private Date DOB;
	
	@NotBlank(message = "Email can't be empty")
	private String email;
	
	private String gender;
	
	@Pattern(regexp = "^[A-Z0-9]+$", message = "PAN can only contain capital letters and numbers")
	@Size(min = 10, max = 10, message = "PAN should have exactly 10 characters")
	private String pan;

	@Pattern(regexp = "^[0-9]{12}$", message = "Aadhar should be a 12-digit number")
	private String aadhar;
	
	@NotBlank(message = "username can't be empty")
	private String username;
	
	@NotBlank(message = "password can't be empty")
	private String password;
	
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
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
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", DOB=" + DOB + ", email=" + email + ", gender=" + gender + ", pan=" + pan + ", aadhar=" + aadhar
				+ ", username=" + username + ", password=" + password + "]";
	}

	public Customer(int id,
			@NotBlank(message = "first name can't be empty") @Pattern(regexp = "^[a-zA-z]+$", message = "only letters allowed") @Size(min = 3, max = 12, message = "first name should have 3 to 12 letters") String firstName,
			@NotBlank(message = "Last name can't be empty") @Pattern(regexp = "^[a-zA-z]+$", message = "only letters allowed") @Size(min = 3, max = 12, message = "Last name should have 3 to 12 letters") String lastName,
			@NotBlank(message = "address can't be empty") String address, Date dOB,
			@NotBlank(message = "Email can't be empty") String email, String gender,
			@Pattern(regexp = "^[A-Z0-9]+$", message = "PAN can only contain capital letters and numbers") @Size(min = 10, max = 10, message = "PAN should have exactly 10 characters") String pan,
			@Pattern(regexp = "^[0-9]{12}$", message = "Aadhar should be a 12-digit number") String aadhar,
			@NotBlank(message = "username can't be empty") String username,
			@NotBlank(message = "password can't be empty") String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		DOB = dOB;
		this.email = email;
		this.gender = gender;
		this.pan = pan;
		this.aadhar = aadhar;
		this.username = username;
		this.password = password;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}
