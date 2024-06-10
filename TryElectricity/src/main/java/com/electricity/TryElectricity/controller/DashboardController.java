package com.electricity.TryElectricity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.electricity.TryElectricity.model.Bill;
import com.electricity.TryElectricity.model.Customer;
import com.electricity.TryElectricity.services.BillServices;
import com.electricity.TryElectricity.services.CustomerServices;

import jakarta.validation.Valid;

@Controller
public class DashboardController {
	@Autowired
	private CustomerServices customerservice;
	
	@Autowired
    private BillServices billServices;
	
	@GetMapping("/customerlist")
	public String getcustomerList(Model model) {
		List<Customer> customerList = customerservice.customerList();
		model.addAttribute("customers",customerList);
		return "customers";
	}
	
	@PostMapping("/customer/delete")
    public String getDelete(@RequestParam("id") int id, Model model) {
        customerservice.deleteById(id);
        String deleteMessage = "Voter Successfully Deleted With Id: " + id;
        model.addAttribute("message", deleteMessage);
        List<Customer> customerList = customerservice.customerList();
        model.addAttribute("customers", customerList);
        return "customers";
    }
	
	@GetMapping("/customer/edit")
    public String getEdit(@RequestParam("id") int id, Model model) {
        System.out.println("check");
    	Customer customer = customerservice.findById(id);
        System.out.println(customer.getFirstName());
        model.addAttribute("customer", customer);
       
        return "updateform";  
    }
	
	
	@PostMapping("/saveupdate")
    public String getUpdate(@Valid @ModelAttribute("customer") Customer customer,BindingResult bindResult) {
    	if(bindResult.hasErrors()) {
    		return "updateform";
    	}
    	customerservice.updateCustomer(customer);
		return "redirect:/customerlist";
    	
    }
	
	
	
	@PostMapping("/customerlist/search")
	public String searchCustomers(@RequestParam("keyword") String keyword, Model model) {
	    List<Customer> searchResults = customerservice.searchCustomers(keyword);
	    model.addAttribute("customers", searchResults);
	    return "customers";
	}
	
	
//	generate bill  form below 
	@GetMapping("/generateBillForm")
    public String showGenerateBillForm() {
        return "generate-bill";
    }

    @PostMapping("/generateBill")
    public String generateBill(@RequestParam("customerId") int customerId, 
                              @RequestParam("amount") double amount, 
                              RedirectAttributes redirectAttributes) {
        Bill generatedBill = billServices.generateBill(customerId, amount);
        redirectAttributes.addFlashAttribute("message", "Bill generated successfully for Customer ID: " + customerId);
        return "redirect:/generateBillForm";
        
        
    }
	
	
	
//	@PostMapping("/generateBill")
//	public String generateBill(@RequestParam("customerId") int customerId, 
//	                          @RequestParam("amount") double amount, 
//	                          RedirectAttributes redirectAttributes) {
//	    // Generate the bill
//	    Bill generatedBill = billServices.generateBill(customerId, amount);
//	    
//	    // Add the generated bill to the model attribute
//	    redirectAttributes.addFlashAttribute("generatedBill", generatedBill);
//	    
//	    // Redirect to a page where the generated bill can be displayed
//	    return "redirect:/viewGeneratedBill";
//	}
	
	
	
	
	
}
