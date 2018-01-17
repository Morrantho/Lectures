package com.project.pets.controllers;

import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.pets.services.UserService;
import com.project.pets.models.User;

@Controller
@RequestMapping("/users")
public class UserController{
	private UserService userService;

	public UserController(UserService userService){
		this.userService = userService;
	}

	@RequestMapping("")
	public String users(@ModelAttribute("user") User user){
		return "user";
	}

	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("user") User user, BindingResult res){
		if( res.hasErrors() ){
			return "user";
		}else{
			userService.create(user);
			return "redirect:/pets";
		}
	}
}
