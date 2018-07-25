package com.project.auctions.controllers;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.project.auctions.services.SellerService;
import javax.validation.Valid;
import com.project.auctions.models.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/sellers")
public class SellerController{
	@Autowired
	private SellerService sellerService;

	@GetMapping("")
	public String seller(@ModelAttribute("seller") Seller seller,HttpSession session){		
		session.invalidate();
		return "seller";
	}	

	@PostMapping("")
	public String register( @Valid @ModelAttribute("seller") Seller seller,BindingResult result,HttpSession session){
		if(result.hasErrors()){
			return "seller";
		}
		
		sellerService.create(seller);
		session.setAttribute("id",seller.getId());
		return "redirect:/auctions";
	}

	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password,RedirectAttributes flash,HttpSession session){
		Seller seller = sellerService.login(email,password);

		if(seller == null){
			flash.addFlashAttribute("error","Invalid Credentials");
			return "redirect:/sellers";
		}else{
			session.setAttribute("id",seller.getId());
			return "redirect:/auctions";
		}
	}
}
