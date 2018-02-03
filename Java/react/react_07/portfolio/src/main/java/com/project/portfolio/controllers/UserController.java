package com.project.portfolio.controllers;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.portfolio.repositories.UserRepository;
import com.project.portfolio.models.User;

import java.util.ArrayList;

@Controller
@RequestMapping("/users")
public class UserController{
	private UserRepository uR;

	public UserController(UserRepository uR){
		this.uR=uR;
	}

	@RequestMapping("")
	@ResponseBody
	public ArrayList<User> all(){
		return (ArrayList<User>) uR.findAll();
	}

	@PostMapping("/new")
	@ResponseBody
	public User create(@RequestBody User user){
		if(user == null){
			return user;
		}else{
			return uR.save(user);
		}
	}
}
