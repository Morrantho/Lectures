package com.project.auctions.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.project.auctions.models.Buyer;
import com.project.auctions.models.Auction;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;
import javax.persistence.JoinColumn;


@Entity
public class Bid{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	public void setId(Long id){
		this.id = id;
	}
	public Long getId(){
		return id;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="buyer_id")
	private Buyer buyer;
	public void setBuyer(Buyer buyer){
		this.buyer = buyer;
	}
	public Buyer getBuyer(){
		return buyer;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="auction_id")
	private Auction auction;
	public void setAuction(Auction auction){
		this.auction=auction;
	}
	public Auction getAuction(){
		return auction;
	}

	private double amount;
	public void setAmount(double amount){
		this.amount = amount;
	}
	public double getAmount(){
		return amount;
	}

	public Bid(){

	}	
}