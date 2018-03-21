package com.project.bnb.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.bnb.repositories.ReviewRepository;
import com.project.bnb.models.Review;

@Service
public class ReviewService {
	private ReviewRepository rR;
		
	public ReviewService(ReviewRepository rR){
		this.rR=rR;
	}
	
	public void create(Review Review){
		rR.save(Review);
	}

	public Review find(Long id){
		return (Review)rR.findOne(id);
	}

	public ArrayList<Review> all(){
		return (ArrayList<Review>)rR.findAll();
	}

	public void update(Review Review){
		rR.save(Review);
	}

	public void destroy(Long id){
		rR.delete(id);
	}
}
