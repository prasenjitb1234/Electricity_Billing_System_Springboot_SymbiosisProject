package com.electricity.TryElectricity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.electricity.TryElectricity.model.Customer;
import com.electricity.TryElectricity.services.CustomerServices;


import jakarta.validation.Valid;

@Controller
@Transactional
public class CustomerController {
	@Autowired
	private CustomerServices customerservice;
	
	@GetMapping("/registerCustomer")
	public String regiCustomer(Model model) {
		model.addAttribute("customer",new Customer());
		return "customerregistration";
	}
	
	
	@PostMapping("/status")
    public String getStatus(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindResult) {
        if (bindResult.hasErrors()) {
            return "customerregisteration";
        }
        customerservice.saveRegistered(customer);
        // Redirect to the login page after successful registration
        return "redirect:/customerlogin";
    }
	

    @GetMapping("/viewProfile/{id}")
    public String viewProfile(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerservice.findById(id));
        return "viewProfile";
    }

    @GetMapping("/editProfile/{id}")
    public String showEditProfileForm(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerservice.findById(id));
        return "editProfile";
    }

    @PostMapping("/updateProfile")
    public String updateProfile(@Valid @ModelAttribute Customer customer, BindingResult bindResult) {
        if (bindResult.hasErrors()) {
            return "editProfile";
        }
        customerservice.updateCustomer(customer);
        return "redirect:/viewProfile/" + customer.getId();
    }
	
}
