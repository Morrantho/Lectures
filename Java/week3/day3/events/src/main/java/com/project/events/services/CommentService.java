package com.project.events.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.project.events.models.Comment;
import com.project.events.repositories.CommentRepository;

@Service
public class CommentService {
	private CommentRepository commentRepository;
	
	public CommentService(CommentRepository commentRepository){
		this.commentRepository=commentRepository;
	}

	public ArrayList<Comment> all(){
		return (ArrayList<Comment>)commentRepository.findAll();
	}

	public Comment findById(long id){
		return (Comment) commentRepository.findOne(id);
	}

	public void create(Comment comment){
		commentRepository.save(comment);
	}

	public void update(Comment comment){
		commentRepository.save(comment);
	}

	public void destroy(long id){
		commentRepository.delete(id);
	}

}
