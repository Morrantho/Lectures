package com.project.auctions.controllers;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.project.auctions.services.BuyerService;
import javax.validation.Valid;
import org.springframework.ui.Model;

import com.project.auctions.models.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/buyers")
public class BuyerController{
	@Autowired
	private BuyerService buyerService;

	@GetMapping("")
	public String buyer(@ModelAttribute("buyer") Buyer buyer,HttpSession session){	
		session.invalidate();
		return "buyer";
	}	

	@PostMapping("")
	public String register( @Valid @ModelAttribute("buyer") Buyer buyer,BindingResult result,HttpSession session){
		if(result.hasErrors()){
			return "buyer";
		}
		buyerService.create(buyer);
		session.setAttribute("id",buyer.getId());
		return "redirect:/auctions";
	}

	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password,RedirectAttributes flash,HttpSession session){
		Buyer buyer = buyerService.login(email,password);

		if(buyer == null){
			flash.addFlashAttribute("error","Invalid Credentials");
			return "redirect:/buyers";
		}else{
			session.setAttribute("id",buyer.getId());
			return "redirect:/auctions";
		}
	}
}
