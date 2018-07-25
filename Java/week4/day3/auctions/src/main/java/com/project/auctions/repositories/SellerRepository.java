package com.project.auctions.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.project.auctions.models.Seller;
import java.util.List;

@Repository
public interface SellerRepository extends CrudRepository<Seller,Long>{
	List<Seller> findAll();
	Seller findOne(Long id);
	Seller findByEmail(String email);
}