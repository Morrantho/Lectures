package com.project.studentsApp.controllers;

import java.security.Principal;
import java.util.Date;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.project.studentsApp.models.Student;

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
@RequestMapping("/")
public class StudentController{
	private static ArrayList<Student> students = new ArrayList<Student>();

	public StudentController(){}
	
	@RequestMapping("")
	public String index(Model model,HttpSession session){
		session.setAttribute("allStudents",students);

		return "index";
	}

	@PostMapping("students/new")
	public String create( 
		@RequestParam("firstName") String firstName, 
		@RequestParam("lastName") String lastName,
		@RequestParam("stack") int stack,
		RedirectAttributes flash
		){

		if(firstName.length() < 1){
			flash.addFlashAttribute("error","You forgot a first name!!!!");
			return "redirect:/";
		}

		Student student = new Student( firstName, lastName, stack );

		students.add( student );

		return "redirect:/";
	}

	@RequestMapping("/students/{id}")
	public String show( @PathVariable("id") int studentId, Model model ){
		Student student = students.get( studentId );
		model.addAttribute( "student", student );

		return "showStudent";
	}
}
