package com.project.auctions.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.auctions.models.Bid;
import com.project.auctions.repositories.BidRepository;
import java.util.List;

@Service
public class BidService{
	@Autowired
	private BidRepository bidRepository;

	public void create(Bid bid){
		bidRepository.save(bid);
	}

	public List<Bid> findAll(){
		return bidRepository.findAll();
	}

	public Bid findOne(Long id){
		return bidRepository.findOne(id);
	}

	public void update(Bid bid){
		bidRepository.save(bid);
	}

	public void destroy(Long id){
		bidRepository.delete(id);
	}
}