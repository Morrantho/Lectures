package com.project.auctions.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.project.auctions.models.Buyer;
import java.util.List;

@Repository
public interface BuyerRepository extends CrudRepository<Buyer,Long>{
	List<Buyer> findAll();
	Buyer findOne(Long id);
	Buyer findByEmail(String email);
}