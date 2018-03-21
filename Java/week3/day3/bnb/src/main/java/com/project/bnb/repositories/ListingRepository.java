package com.project.bnb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.bnb.models.Listing;

@Repository 												
public interface ListingRepository extends CrudRepository<Listing,Long>{
	public List<Listing> findByAddress(String address);
}
