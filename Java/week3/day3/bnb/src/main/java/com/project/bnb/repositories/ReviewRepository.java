package com.project.bnb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.bnb.models.Review;

@Repository 												
public interface ReviewRepository extends CrudRepository<Review,Long>{
}
