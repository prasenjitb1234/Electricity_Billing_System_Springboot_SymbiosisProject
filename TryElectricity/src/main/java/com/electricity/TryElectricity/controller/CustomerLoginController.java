package com.electricity.TryElectricity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.electricity.TryElectricity.model.Customer;
import com.electricity.TryElectricity.model.customerHome;
import com.electricity.TryElectricity.services.CustomerServices;
import com.electricity.TryElectricity.services.ProfileServices;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@Transactional
public class CustomerLoginController {

	@Autowired
	private CustomerServices customerservice;
	@Autowired
	private ProfileServices profServices;
	
	@GetMapping("/customerlogin")
    public String getLogin(Model model) {
        model.addAttribute("customerhome", new customerHome());
        return "customerhome"; 
    }
	
	
	// need to change code below 
	
	@PostMapping("/loginstatus")
    public String getlogstatus(@Valid @ModelAttribute("customerhome") customerHome customerhome, BindingResult bindResult, Model model,HttpSession session) {
        if (bindResult.hasErrors()) {
            return "customerhome"; 
        }

        List<Customer> dbcustomerList = customerservice.customerList();
        boolean found = false;
        int id = 0;

        for (Customer dbc : dbcustomerList) {
            if (dbc.getUsername().equals(customerhome.getUsername()) && dbc.getPassword().equals(customerhome.getPassword())) {
                id = dbc.getId();
                profilepicController.setId(id);
                session.setAttribute("customerId", id);
                found = true;
            }
        }

        if (found==true) {
            if(profServices.existById(id)) {
            return "check"; 
            }else {
            	return "redirect:/profileImage";
            }
        } else {
            model.addAttribute("error", "Incorrect username or password");
            return "customerhome"; 
        }
    }
	
	

	
}
