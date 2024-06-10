package com.electricity.TryElectricity.services;

import java.util.List;

import com.electricity.TryElectricity.model.Bill;
import com.electricity.TryElectricity.model.Customer;

public interface BillServices {
	Bill generateBill(int customerId, double amount);
    List<Bill> getBillsByCustomerId(int customerId);
    void markBillAsPaid(int billId);
    
    public List<Bill> billList();
}
