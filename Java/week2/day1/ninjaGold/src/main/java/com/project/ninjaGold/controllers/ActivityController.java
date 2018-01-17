package com.project.ninjaGold.controllers;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.ninjaGold.models.Activity;

import java.util.ArrayList;

@Controller
@RequestMapping("/activities")
public class ActivityController{
	public ActivityController(){

	}
	
	public void reverse(ArrayList<Activity> list){
		Activity temp;

		for(int i=0,j=list.size()-1;i < list.size()/2; i++,j--){
			temp = list.get( i );
			list.set( i, list.get( j ) );
			list.set( j, temp );
		}
	}

	@RequestMapping("")
	public String activities(HttpSession session){
		if( session.getAttribute("activities") == null || session.getAttribute("gold") == null ){
			ArrayList<Activity> activities = new ArrayList<Activity>();
			session.setAttribute("activities",activities);
			session.setAttribute("gold",0);
			session.setAttribute("lastSize",0);
		}

		int lastSize = (int)session.getAttribute("lastSize");
		ArrayList<Activity> activities = (ArrayList<Activity>)session.getAttribute("activities");

		if(lastSize != activities.size()){
			session.setAttribute("lastSize",activities.size());
			reverse( activities );
		}

		session.setAttribute("activities",activities);

		return "activities";
	}

	@PostMapping("/new")
	public String create(@RequestBody String body,HttpSession session){
		String location   = body.substring(0, body.indexOf("=") );
		Activity activity = new Activity();
		int gold = (int)session.getAttribute("gold");

		switch(location){
			case "farm":
				activity = new Activity(location,10,20);
				break;
			case "cave":
				activity = new Activity(location,5,10);
				break;
			case "house":
				activity = new Activity(location,2,5);
				break;
			case "casino":
				activity = new Activity(location,-50,50);
				break;
		}

		gold += activity.getGold();

		ArrayList<Activity> activities = (ArrayList<Activity>)session.getAttribute("activities");
		activities.add(activity);
		session.setAttribute("activities",activities);
		session.setAttribute("gold",gold);

		return "redirect:/activities";
	}
}
