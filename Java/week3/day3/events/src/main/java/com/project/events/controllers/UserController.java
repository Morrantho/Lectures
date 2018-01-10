package com.project.events.controllers;

import com.project.events.models.Event;
import com.project.events.models.User;
import com.project.events.services.CommentService;
import com.project.events.services.EventService;
import com.project.events.services.UserService;
import com.project.events.validators.UserValidator;

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

@Controller
public class UserController{
	private UserService userService;
	private UserValidator userValidator;
	private EventService eventService;
	private CommentService commentService;

	public UserController(UserService userService, UserValidator userValidator, EventService eventService,
			CommentService commentService) {
		this.userService = userService;
		this.userValidator=userValidator;
		this.eventService=eventService;
		this.commentService=commentService;
    }

	@RequestMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user) {
		return "register";
	}

	@PostMapping("/register")
	public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model,
			HttpSession session) {
		userValidator.validate(user, result);
		if (result.hasErrors()) {
			return "register";
		}

		if(userService.all().size() < 1){
			userService.saveUserWithAdminRole(user);
		}else{

			userService.saveWithUserRole(user);			
		}
		return "redirect:/login";
	}

	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		if (error != null) {
			model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
		}
		if (logout != null) {
			model.addAttribute("logoutMessage", "Logout Successfull!");
		}
		return "login";
	}

	@RequestMapping(value = { "/", "/dashboard" })
	public String home(Principal principal, Model model) {
		String username = principal.getName();
		model.addAttribute("currentUser", userService.findByEmail(username));
		return "home";
	}

	@RequestMapping("/admin")
	public String adminPage(Principal principal, Model model) {
		String username = principal.getName();
		model.addAttribute("currentUser", userService.findByEmail(username));
		return "admin";
	}

	@RequestMapping("/events")
	public String events(@ModelAttribute("event") Event event){
		return "events";
	}

	@PostMapping("/events/new")
	public String createEvent(@Valid @ModelAttribute("event") Event event,BindingResult result){
		if( result.hasErrors() ){
			return "events";
		}else{
			eventService.create(event);
			return "redirect:/events";
		}

	}
}
