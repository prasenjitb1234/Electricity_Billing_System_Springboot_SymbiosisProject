package com.electricity.TryElectricity.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electricity.TryElectricity.dao.BillRepo;
import com.electricity.TryElectricity.model.Bill;
import com.electricity.TryElectricity.model.Customer;

@Service
public class BillServicesImp implements BillServices{
	
	 @Autowired
	    private BillRepo billRepo;

	 @Autowired
	    private CustomerServices customerServices;

	 @Override
	 public Bill generateBill(int customerId, double amount) {
	     Customer customer = customerServices.findById(customerId);
	     Bill bill = new Bill();
	     bill.setCustomer(customer);
	     bill.setAmount(amount);
//	     bill.setDueDate(new Date(new java.util.Date().getTime())); // Set the current date as the due date
	     bill.setDueDate(Date.valueOf(LocalDate.now()));
	     bill.setPaid(false);
	     return billRepo.save(bill);
	 }

	@Override
	public List<Bill> getBillsByCustomerId(int customerId) {
		// TODO Auto-generated method stub
		return billRepo.findByCustomerId(customerId);
	}

	@Override
	public void markBillAsPaid(int billId) {
		// TODO Auto-generated method stub
		 Bill bill = billRepo.findById(billId).orElse(null);
	        if (bill != null) {
	            bill.setPaid(true);
	            billRepo.save(bill);
	        }
	}

	@Override
	public List<Bill> billList() {
		// TODO Auto-generated method stub
		List<Bill> findAll = billRepo.findAll();
		return findAll;
	}

	
	
	
}
