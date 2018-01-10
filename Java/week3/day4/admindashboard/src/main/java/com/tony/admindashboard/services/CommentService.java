package com.tony.admindashboard.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tony.admindashboard.models.Comment;
import com.tony.admindashboard.repositories.CommentRepository;

@Service
public class CommentService {
	private CommentRepository commentRepository;

	public CommentService(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}

	public ArrayList<Comment> all() {
		return (ArrayList<Comment>) commentRepository.findAll();
	}

	public Comment findById(long id) {
		return commentRepository.findOne(id);
	}

	// public Comment findByName(String name) {
	// 	return CommentRepository.findByName(name);
	// }

	public void create(Comment comment) {
		commentRepository.save(comment);
	}

	public void update(Comment comment) {
		commentRepository.save(comment);
	}

	public void destroy(long id) {
		commentRepository.delete(id);
	}
}
