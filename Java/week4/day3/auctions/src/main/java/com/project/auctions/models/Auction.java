package com.project.auctions.models;

import java.util.Date;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.project.auctions.models.Seller;

@Entity
public class Auction{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	public void setId(Long id){
		this.id = id;
	}
	public Long getId(){
		return id;
	}

	private String name;
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}

	private double startingBid;
	public void setStartingBid(double startingBid){
		this.startingBid = startingBid;
	}
	public double getStartingBid(){
		return startingBid;
	}

	private String description;
	public void setDescription(String description){
		this.description = description;
	}
	public String getDescription(){
		return description;
	}

	private Date remaining;
	public void setRemaining(Date date){
		remaining = date;
	}
	public Date getRemaining(){
		return remaining;
	}

	private double topBid;
	public void setTopBid(double topBid){
		this.topBid = topBid;
	}
	public double getTopBid(){
		return topBid;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="seller_id")
	private Seller seller;
	public void setSeller(Seller seller){
		this.seller = seller;
	}
	public Seller getSeller(){
		return seller;
	}

	@OneToMany(mappedBy="auction",fetch=FetchType.LAZY)
	private List<Bid> bids;
	public void setBids(List<Bid> bids){
		this.bids = bids;
	}
	public List<Bid> getBids(){
		return bids;
	}

	public Auction(){

	}
}