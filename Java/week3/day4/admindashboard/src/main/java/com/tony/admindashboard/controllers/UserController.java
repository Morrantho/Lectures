package com.tony.admindashboard.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.tony.admindashboard.models.Event;
import com.tony.admindashboard.models.Role;
import com.tony.admindashboard.models.User;
import com.tony.admindashboard.models.Comment;
import com.tony.admindashboard.services.CommentService;
import com.tony.admindashboard.services.EventService;
import com.tony.admindashboard.services.RoleService;
import com.tony.admindashboard.services.UserService;
import com.tony.admindashboard.validations.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	private UserValidator userValidator;
	@Autowired
	private EventService eventService;
	private CommentService commentService;

	public UserController(UserService userService,RoleService roleService,UserValidator userValidator,EventService eventService, CommentService commentService){
		this.userService = userService;
		this.roleService = roleService;
		this.userValidator = userValidator;
		this.eventService = eventService;
		this.commentService=commentService;
	}
	
	@RequestMapping(value={"/login","/register"})
	public String login(Model model,@RequestParam(value="error",required=false) String error,@RequestParam(value="logout",required=false) String logout){
		if(error != null){model.addAttribute("errorMessage","Invalid Credentials.");}
		if(logout != null){model.addAttribute("logoutMessage","Logout Successful");}
		
		model.addAttribute("user",new User());
		return "login_register";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user,BindingResult res,Model model){
		userValidator.validate(user,res);
		if(res.hasErrors()){return "login_register";}
		
		if(roleService.findByName("ROLE_ADMIN").getUsers().size() < 1){ // Less than one admin? Make them admin, else user.
			userService.create(new String[]{"ROLE_USER","ROLE_ADMIN"}, user);
		}else{
			userService.create(new String[]{"ROLE_USER"}, user);
		}
		return "redirect:/login";
	}

	@RequestMapping("/superadmin")
	public String superadmin(Principal principal,Model model){
		model.addAttribute("user",userService.findByEmail(principal.getName()));
		return "superadmin";
	}
	
	@RequestMapping("/admin")
	public String admin(Principal principal,Model model){		
		model.addAttribute("user",userService.findByEmail(principal.getName()));
		model.addAttribute("users",userService.all());
		return "admin";
	}
	
	@RequestMapping("/admin/delete/{id}")
	public String delete(@PathVariable("id") long id){
		userService.destroy(id);
		return "redirect:/admin";
	}
	
	@RequestMapping("/admin/promote/{id}")
	public String promote(@PathVariable("id") long id){
		User user = userService.getById(id);
		List<Role> userRoles = user.getRoles();
		userRoles.add(roleService.findByName("ROLE_ADMIN"));
		userService.update(user);
		
		return "redirect:/admin";
	}
	
	@RequestMapping(value={"/","/dashboard"})
	public String dashboard(Principal principal,Model model){
		User user = userService.findByEmail(principal.getName());
		model.addAttribute("user",user);
		// user.setUpdatedAt(new Date());
		userService.update(user);
		
		if(user.isSuperAdmin()){
			return "redirect:/superadmin";
		}else if(user.isAdmin()){
			return "redirect:/admin";
		}else{
			return "dashboard";
		}
	}

	@RequestMapping("/events")
	public String events(@ModelAttribute("event") Event event,Principal principal,Model model){
		User user = userService.findByEmail(principal.getName());
		ArrayList<Event> localEvents = new ArrayList<Event>();
		ArrayList<Event> otherEvents = new ArrayList<Event>();

		for(Event e:eventService.all()){
			if(e.getState().equals(user.getState())){
				localEvents.add(e);
			}else{
				otherEvents.add(e);
			}
		}
		model.addAttribute("localEvents",localEvents);
		model.addAttribute("otherEvents", otherEvents);

		return "events";
	}

	@PostMapping("/events/new")
	public String createEvent(@Valid @ModelAttribute("event") Event event,BindingResult res){
		if( res.hasErrors() ){
			return "events";
		}else{
			eventService.create(event);
			return "redirect:/events";
		}
	}

	@RequestMapping("/events/{id}")
	public String editEvent(@PathVariable("id") long id,Model model,@ModelAttribute("comment") Comment comment){
		model.addAttribute("event", eventService.findById(id));
		return "editEvent";
	}

	@PostMapping("/events/{id}/comments/new")
	public String newComment(@Valid @ModelAttribute("comment") Comment comment,BindingResult res,@PathVariable("id") long id){

		if (res.hasErrors()) {
			return "redirect:/events";
		} else {
			Event event = eventService.findById(id);
			// comment.setEvent(event);

			Comment c = new Comment();
			c.setText(comment.getText());
			c.setUser(comment.getUser());
			c.setEvent(event);

			commentService.create(c);

			// Event event = eventService.findById(id);

			
			// List<Comment> comments = event.getComments();
			// comments.add(comment);
			// eventService.update(event);

			return "redirect:/events/"+id;
		}

	}
}