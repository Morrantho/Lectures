package com.project.login.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.login.models.User;
import com.project.login.services.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String dashboard(HttpSession session,Model model){
		if(session.getAttribute("id") != null) {
			User user = userService.findById((Long)session.getAttribute("id"));
			
			if(user != null) {
				model.addAttribute("user",user);
				return "dashboard";
			}else {
				return "redirect:/register";
			}			
		}else{
			return "redirect:/register";
		}
	}
	
	@GetMapping("/register")
	public String register(@ModelAttribute("user") User user,HttpSession session){
		session.invalidate();
		return "register";
	}
	
	@PostMapping("/register")
	public String create(@Valid @ModelAttribute("user") User user, BindingResult res, RedirectAttributes flash, HttpSession session){
		if(res.hasErrors()) {
			flash.addFlashAttribute("errors",res.getAllErrors());
			return "redirect:/register";
		}
		
		User registerer = userService.register(user);
		
		if(registerer != null){
			session.setAttribute("id",registerer.getId());
			return "redirect:/";
		}else {
			flash.addFlashAttribute("registerError","A user with this email already exists.");
			return "redirect:/register";
		}
	}
	
	@PostMapping("/login")
	public String login( @RequestParam("email") String email, @RequestParam("password") String password, HttpSession session, RedirectAttributes flash){
		User user = userService.login(email, password);
		
		if(user == null) {
			flash.addFlashAttribute("registerError","Invalid Credentials");
			return "redirect:/register";
		}else {
			session.setAttribute("id",user.getId());
			return "redirect:/";
		}
	}
}
