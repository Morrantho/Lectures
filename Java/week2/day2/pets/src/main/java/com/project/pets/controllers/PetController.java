package com.project.pets.controllers;

import java.util.ArrayList;
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

import com.project.pets.services.PetService;
import com.project.pets.models.Pet;

import com.project.pets.services.UserService;
import com.project.pets.models.User;

@Controller
@RequestMapping("/pets")
public class PetController{
	private UserService userService;
	private PetService petService;

	public PetController(PetService petService,UserService userService){
		this.petService = petService;
		this.userService = userService;
	}

	@RequestMapping("")
	public String pets(@ModelAttribute("pet") Pet pet,Model model){
		ArrayList<User> users = userService.all();
		model.addAttribute("users",users);
		return "pet";
	}

	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("pet") Pet pet,BindingResult res){
		if( res.hasErrors() ){
			return "pet";
		}else{
			petService.create(pet);
			return "redirect:/pets";
		}
	}
}
