package com.project.auctions.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.project.auctions.models.Auction;
import java.util.List;

@Repository
public interface AuctionRepository extends CrudRepository<Auction,Long>{
	List<Auction> findAll();
	Auction findOne(Long id);
}
