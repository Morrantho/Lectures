package com.project.auctions.controllers;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.project.auctions.services.AuctionService;
import com.project.auctions.services.BidService;
import com.project.auctions.services.SellerService;
import com.project.auctions.services.BuyerService;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import com.project.auctions.models.Auction;
import com.project.auctions.models.Seller;
import com.project.auctions.models.Buyer;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/auctions")
public class AuctionController{
	@Autowired
	private BidService bidService;
	@Autowired
	private SellerService sellerService;
	@Autowired
	private BuyerService buyerService;

	@GetMapping("")
	public String auctions(Model model){
		model.addAttribute("bids",bidService.findAll());

		return "auctions";
	}

	@GetMapping("/new")
	public String newAuction(@ModelAttribute("auction") Auction auction,HttpSession session){
		Long id = (Long)session.getAttribute("id");
		if(id == null){

		}else{
			
		}
		return "newAuction";
	}
}