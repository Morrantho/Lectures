package com.tony.admindashboard.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tony.admindashboard.models.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
	// public Event findByEmail(String email);
}
