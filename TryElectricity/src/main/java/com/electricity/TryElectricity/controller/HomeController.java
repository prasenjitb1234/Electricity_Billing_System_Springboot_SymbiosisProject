package com.electricity.TryElectricity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;

@Controller
public class HomeController {

	
	@GetMapping("/ebill")
	public String showHome(Model model) {
//		model.addAttribute("index",new Index());
		return "homepage";
	}
}
