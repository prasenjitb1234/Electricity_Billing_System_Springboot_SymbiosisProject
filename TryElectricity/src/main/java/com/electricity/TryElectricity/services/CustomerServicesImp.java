package com.electricity.TryElectricity.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electricity.TryElectricity.dao.CustomerRepo;
import com.electricity.TryElectricity.model.Customer;

@Service
public class CustomerServicesImp implements CustomerServices {

	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public Customer saveRegistered(Customer customer) {
		return customerRepo.save(customer);
	}

	@Override
	public List<Customer> customerList() {
		List<Customer> findAll = customerRepo.findAll();
		return findAll;
	}

	@Override
	public void deleteById(int id) {
		customerRepo.deleteById(id);

	}

	@Override
	public Customer findById(int id) {
		Optional<Customer> findById = customerRepo.findById(id);
		Customer customer = findById.get();
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	@Override
	public List<Customer> searchCustomers(String keyword) {
		List<Customer> allCustomers = customerRepo.findAll();
	    List<Customer> searchResults = new ArrayList<>();

	    for (Customer customer : allCustomers) {
	        if (customer.getFirstName().toLowerCase().contains(keyword.toLowerCase())
	                || customer.getLastName().toLowerCase().contains(keyword.toLowerCase())
	                || customer.getEmail().toLowerCase().contains(keyword.toLowerCase())) {
	            searchResults.add(customer);
	        }
	    }
		return searchResults;
	}
	
	

}
