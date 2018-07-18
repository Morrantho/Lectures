package com.project.login.controllers;

import javax.validation.Valid;

import com.project.login.models.Customer;
import com.project.login.repositories.CustomerRepository;
import com.project.login.services.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomerController{
    @Autowired
	private CustomerService customerService;

	@GetMapping("")
	public String customers(Model model){
		model.addAttribute("customers",customerService.all());
		model.addAttribute("customer",new Customer());
		return "customers";
	}

	@PostMapping("")
	public String create(@Valid @ModelAttribute("customer") Customer customer, BindingResult result,Model model){
		if(result.hasErrors()){
			model.addAttribute("customers",customerService.all());
			return "customers";
		}
		customerService.create(customer);
		return "redirect:/customers";
	}

	@GetMapping("/{id}/delete")
	public String destroy(@PathVariable("id") Long id ){
		customerService.destroy(id);
		return "redirect:/customers";
	}
}