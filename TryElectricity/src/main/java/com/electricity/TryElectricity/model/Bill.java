package com.electricity.TryElectricity.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@Column(name = "amount", nullable = false)
	private double amount;
	private Date dueDate;
	private boolean isPaid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", customer=" + customer + ", amount=" + amount + ", dueDate=" + dueDate + ", isPaid="
				+ isPaid + "]";
	}

	public Bill(int id, Customer customer, double amount, Date dueDate, boolean isPaid) {
		super();
		this.id = id;
		this.customer = customer;
		this.amount = amount;
		this.dueDate = dueDate;
		this.isPaid = isPaid;
	}

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

}
