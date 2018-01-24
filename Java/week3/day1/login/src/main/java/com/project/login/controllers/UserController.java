package com.project.login.controllers;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.login.models.User;
import com.project.login.services.UserService;


@Controller
public class UserController{
	private UserService us;

	public UserController(UserService us){
		this.us=us;
	}
	
	@ResponseBody
	@RequestMapping("/dashboard")
	public ArrayList<User> dashboard(HttpSession s,Model model){
		return (ArrayList<User>)us.all();

		// if( s.getAttribute("id") != null ){

			// return "dashboard";
		// }else{
			// return "redirect:/";
		// }
	}

	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password,HttpSession s){
		User user = us.findByEmail(email);
		
		if( user == null ){
			return "redirect:/";
		}else{
			if( us.isMatch( password ,user.getPassword() ) ){
				s.setAttribute("id",user.getId());
				return "redirect:/dashboard";
			}else{
				return "redirect:/";
			}
		}	
	}

	@RequestMapping("/logout")
	public String logout(HttpSession s){
		s.setAttribute("id",null);
		return "redirect:/";
	}

	@RequestMapping("/register")
	public String register(@ModelAttribute("user") User user,HttpSession s){
		s.setAttribute("id",null);
		return "register";
	}

	@PostMapping("/register")
	public String create(@Valid @ModelAttribute("user") User user,BindingResult res,HttpSession session){
		if(res.hasErrors()){
			return "register";
		}else{
			us.create(user);
			session.setAttribute( "id",user.getId() );
			return "redirect:/";
		}
	}
}
