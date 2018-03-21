package com.project.bnb.controllers;

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

import com.project.bnb.services.UserService;
import com.project.bnb.models.User;

@Controller
@RequestMapping("/**") // Wildcard all routes.
public class RouteController{
	private UserService us;

	public RouteController(UserService us){
		this.us=us;
	}
	// If route not exists, redirect to login if not in session, else dashboard.
	@RequestMapping("")
	public String index(HttpServletRequest req,HttpSession s){		
		if(!us.isValid(s)){
			return "redirect:/users/new";
		}else{
			User user = us.find((long) s.getAttribute("id"));

			if(user.isHost()){
				return "redirect:/listings/host";
			}else{
				return "redirect:/listings";
			}
		}
	}	
}
