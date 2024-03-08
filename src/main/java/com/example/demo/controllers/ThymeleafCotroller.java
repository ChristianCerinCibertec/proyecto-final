package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ThymeleafCotroller {

	@GetMapping("/thymeleaf")
	public String thymeleaf() {
		return "thymeleaf";
		
	}
	
	
	
	@GetMapping("/thymeleaf2")

	public String thymeleaf2(Model model){

		model.addAttribute("mensaje", "Hola a todos!!!!");

		return "thymeleaf2";

	}
	
	
	@GetMapping("/thymeleaf3")

	public String thymeleaf3(Model model){
		
		//List<Subject> listSubject = new ArrayList<Subject>();
		

		model.addAttribute("mensaje", "Hola a todos!!!!");

		return "thymeleaf3";

	}
	
}
