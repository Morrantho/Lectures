package com.project.auctions.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.project.auctions.models.Bid;
import java.util.List;

@Repository
public interface BidRepository extends CrudRepository<Bid,Long>{
	List<Bid> findAll();
	Bid findOne(Long id);
}