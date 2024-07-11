package com.electricity.TryElectricity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.electricity.TryElectricity.model.Complaint;
import com.electricity.TryElectricity.services.ComplaintService;

@Controller
public class ComplaintController {

	@Autowired
	private ComplaintService complaintService;

	@GetMapping("/giveComplaintForm")
	public String showComplaintForm( ) {
		
		return "give-complaint"; // Assuming you have a template for complaint form
	}

	@PostMapping("/giveComplaint")
	public String giveComplaint(Complaint complaint, Model model) {
		complaintService.saveComplaint(complaint);
		model.addAttribute("message", "Complaint submitted successfully");
		return "redirect:/giveComplaintForm"; // Redirect to the complaint form page
	}

	@GetMapping("/viewComplaints")
	public String viewComplaints(Model model) {
		model.addAttribute("complaints", complaintService.getAllComplaints());
		return "view-complaints"; // Assuming you have a template for viewing complaints
	}
}
