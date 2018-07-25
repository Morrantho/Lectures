package com.project.auctions.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.auctions.models.Auction;
import com.project.auctions.repositories.AuctionRepository;
import java.util.List;

@Service
public class AuctionService{
	@Autowired
	private AuctionRepository auctionRepository;

	public void create(Auction auction){
		auctionRepository.save(auction);
	}

	public List<Auction> findAll(){
		return auctionRepository.findAll();
	}

	public Auction findOne(Long id){
		return auctionRepository.findOne(id);
	}

	public void update(Auction auction){
		auctionRepository.save(auction);
	}

	public void destroy(Long id){
		auctionRepository.delete(id);
	}
}