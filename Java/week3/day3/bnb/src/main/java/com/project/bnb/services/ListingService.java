package com.project.bnb.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.bnb.repositories.ListingRepository;
import com.project.bnb.models.Listing;

@Service
public class ListingService {
	private ListingRepository lR;
		
	public ListingService(ListingRepository lR){
		this.lR=lR;
	}
	
	public void create(Listing listing){
		lR.save(listing);
	}

	public Listing find(Long id){
		return (Listing)lR.findOne(id);
	}

	public ArrayList<Listing> all(){
		return (ArrayList<Listing>)lR.findAll();
	}

	public void update(Listing listing){
		lR.save(listing);
	}

	public void destroy(Long id){
		lR.delete(id);
	}

	public ArrayList<Listing> findByAddress(String address){
		return (ArrayList<Listing>)lR.findByAddress(address);
	}
}