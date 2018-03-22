package com.project.bnb.controllers;

import java.security.Principal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import java.lang.CharSequence;

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

import com.project.bnb.services.ReviewService;
import com.project.bnb.services.ListingService;
import com.project.bnb.services.UserService;
import com.project.bnb.models.Listing;
import com.project.bnb.models.User;
import com.project.bnb.models.Review;

@Controller
@RequestMapping("/listings")
public class ListingController{
	private ListingService lS;
	private ReviewService rS;
	private UserService uS;

	public ListingController(ListingService lS,UserService uS,ReviewService rS){
		this.lS=lS;
		this.uS=uS;
		this.rS=rS;
	}

	@RequestMapping("")
	public String listings(HttpSession session,Model model){
		User user;

		if(session.getAttribute("id") != null){
			user = uS.find( (Long) session.getAttribute("id"));
			model.addAttribute("user",user);
		}
		model.addAttribute("listings",lS.all());

		return "guest";
	}

	@RequestMapping("/host")
	public String host(HttpSession session,Model model){
		if(session.getAttribute("id") == null){
			System.out.println("NOT IN SESSION");
			return "redirect:/users/new";
		}
		User user = uS.find( (Long)session.getAttribute("id") );
		if(!user.isHost()){
			System.out.println("NOT A HOST, REDIRECTING");
			return "redirect:/listings";
		}

		model.addAttribute("user",user);
		model.addAttribute("listing",new Listing());
		return "host";
	}

	@PostMapping("")
	public String create(@Valid @ModelAttribute("listing") Listing listing,BindingResult res,HttpSession session){
		if(session.getAttribute("id") == null){return "redirect:/users/new";}
		User user = uS.find((Long)session.getAttribute("id"));

		if(!user.isHost()){
			return "redirect:/listings";
		}else{		
			if(res.hasErrors()){
				return "/listings/host";
			}else{
				System.out.println("CREATE LISTING: "+user);
				listing.setUser(user);
				listing.setAverage(0);
				lS.create(listing);
				return "redirect:/listings/host";
			}
		}
	}

	@RequestMapping("{id}")
	public String find(@PathVariable("id") Long id,Model model,HttpSession session){
		if(session.getAttribute("id") != null){
			User user = uS.find( (Long)session.getAttribute("id"));
			model.addAttribute("user",user);	
		}

		model.addAttribute("listing",lS.find(id));
		return "reviews";
	}

	@RequestMapping("{id}/review")
	public String review(@PathVariable("id") Long id,HttpSession session,Model model){
		if(session.getAttribute("id") != null){
			User user = uS.find( (Long)session.getAttribute("id"));
			model.addAttribute("user",user);	
		}else{
			return "redirect:/listings/"+id;
		}

		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for(int i=1;i<6;i++)
			numbers.add(i);

		model.addAttribute("numbers",numbers);
		model.addAttribute("listing",lS.find(id));
		model.addAttribute("review",new Review());
		return "review";
	}

	@PostMapping("{id}/review")
	public String createReview(@PathVariable("id") Long id,@ModelAttribute("review") Review review, BindingResult res,HttpSession session){
		if(session.getAttribute("id") == null){return "/listings/"+id+"/review";}
		User user = uS.find((Long)session.getAttribute("id"));
		if(user.isHost()){return "/listings";}

		if(res.hasErrors()){
			return "review";
		}else{
			Listing listing = lS.find(id);

			review.setId(null);
			List<Review> reviews = listing.getReviews();
			reviews.add(review);
			listing.setReviews(reviews);

			double sum = 0;

			for(Review rev: listing.getReviews()){
				sum += rev.getRating();
			}
			sum += review.getRating();
			sum /= listing.getReviews().size()+1;
			listing.setAverage(sum);

			review.setListing(listing);
			review.setUser(user);
			rS.create(review);
			lS.update(listing);

			return "redirect:/listings/";
		}
	}
	// Search for part of a word in a string.
	public boolean scrub(String needle,String haystack){
		needle = needle.toLowerCase();

		for(int j=0;j<haystack.length()-needle.length()+1;j++){
			String res = haystack.substring(j,j+needle.length()).toLowerCase();
			// Found match and listing isnt already pushed
			if(res.indexOf(needle) != -1){
				return true;
			}
		}
		return false;
	}

	@RequestMapping("search")
	public String search(@RequestParam("search") String search,HttpSession session,Model model){
		User user;

		if(session.getAttribute("id") != null){
			user = uS.find( (Long) session.getAttribute("id"));
			model.addAttribute("user",user);
		}

		ArrayList<Listing> allListings = lS.all();
		ArrayList<Listing> listings = new ArrayList<Listing>();

		for(Listing listing: allListings){
			if(scrub(search,listing.getAddress()) && !listings.contains(listing)){
				listings.add(listing);
			}
			if(scrub(search,listing.getSize()) && !listings.contains(listing)){
				listings.add(listing);
			}
			if(scrub(search,Double.toString(listing.getCost())) && !listings.contains(listing)){
				listings.add(listing);
			}
		}

		model.addAttribute("listings",listings);

		return "guest";
	}

	@PostMapping("{id}")
	public String update(@PathVariable("id") Long id,Model model,HttpSession session,@RequestParam("description") String description,@RequestParam("size") String size,@RequestParam("cost") double cost){
		if(session.getAttribute("id") == null){return "redirect:/users/new";}
		User user = uS.find((Long)session.getAttribute("id"));
		// if(!user.isHost()){return "redirect:/listings/"+id;}
		// if(listing.getUser().getId() != user.getId()){return "redirect:/listings/"+id;}

		Listing listing = lS.find(id);
		listing.setDescription(description);
		listing.setSize(size);
		listing.setCost(cost);
		listing.setUser(user);
		lS.update(listing);
		return "redirect:/"+id;
	}
}