package com.tony.routingApp.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tony.routingApp.models.Student;

@Controller
public class StudentController{
	public static ArrayList<Student> students = new ArrayList<Student>();
	
	@RequestMapping("")
	public String index(Model model){
		model.addAttribute("students",students);
		return "index";
	}
	
	@RequestMapping("/students/new")
	public String create(@RequestParam("firstName") String firstName, @RequestParam("stack") String stack,HttpSession session){
		Student student = new Student(firstName,stack);
		students.add(student);
		session.setAttribute("latest",student);
		
		return "redirect:/";
	}

	@RequestMapping("/students/{studentId}")
	public String showStudent(@PathVariable("studentId") int studentId,Model model){		
		model.addAttribute("student",students.get(studentId));
		
		return "showUser";
	}
	
	@RequestMapping("/session")
	public String session(HttpSession session,Model model){
		Student latest = (Student) session.getAttribute("latest");
		model.addAttribute("latest",latest);
		return "session";
	}
}
