package com.electricity.TryElectricity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.electricity.TryElectricity.model.Bill;
import com.electricity.TryElectricity.model.Customer;
import com.electricity.TryElectricity.services.BillServices;
import com.electricity.TryElectricity.services.CustomerServices;

@Controller
public class CustomerDashboardController {
	
	@Autowired
	private BillServices billServices;

	@Autowired
	private CustomerServices customerservice;
	
	
	
	@PostMapping("/payBill")
	public String payBill(@RequestParam("billId") int billId) {
	    billServices.markBillAsPaid(billId);
	    return "redirect:/customerDashboard";
	}
	
	
	
	@GetMapping("/billlist")
	public String getBillList(Model model) {
	    List<Bill> billList = billServices.billList();
	    model.addAttribute("bills", billList);
	    return "viewbills";
	}
	
	
}
