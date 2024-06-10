package com.electricity.TryElectricity.services;

import java.util.List;

import com.electricity.TryElectricity.model.Customer;

public interface CustomerServices {

	public Customer saveRegistered(Customer customer);

	public List<Customer> customerList();

	public void deleteById(int id);

	public Customer findById(int id);

	public Customer updateCustomer(Customer customer);
	
	
	List<Customer> searchCustomers(String keyword);

}
