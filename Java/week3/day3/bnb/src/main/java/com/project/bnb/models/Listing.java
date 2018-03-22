package com.project.bnb.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Listing{
	@Id
	@GeneratedValue
	private Long id;

	private double average;
	public void setAverage(double average){
		this.average = average;
	}
	public double getAverage(){
		return average;
	}

	@OneToMany(mappedBy="listing",fetch=FetchType.LAZY)
	private List<Review> reviews;
	public void setReviews(List<Review> reviews){
		this.reviews = reviews;
	}
	public List<Review> getReviews(){
		return reviews;
	}

	@Size(min=1,max=255,message="Address is required.")
	private String address;
	public void setAddress(String address){
		this.address=address;
	}
	public String getAddress(){
		return address;
	}

	@Size(min=1,max=255,message="Description is required.")
	private String description;
	public void setDescription(String description){
		this.description = description;
	}
	public String getDescription(){
		return description;
	}

	@NotNull(message="")
	private double cost;
	public void setCost(double cost){
		this.cost=cost;
	}
	public double getCost(){
		return cost;
	}

	@Size(min=1,max=255,message="Size is required.")
	private String size;
	public void setSize(String size){
		this.size=size;
	}
	public String getSize(){
		return size;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	public void setUser(User user){
		this.user = user;
	}
	public User getUser(){
		return user;
	}

	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date createdAt;
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date updatedAt;

	@PrePersist
	public void onCreate(){this.createdAt = new Date();}
	@PreUpdate
	public void onUpdate(){this.updatedAt = new Date();}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	// Setters and Getters go here
	
	public Listing(){
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
}
