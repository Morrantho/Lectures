package com.project.pets.services;

import java.util.ArrayList;
import java.util.List;

// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.pets.repositories.UserRepository;
import com.project.pets.models.User;

@Service
public class UserService {
	private UserRepository userRepository;
		
	public UserService(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	public void create(User user){
		userRepository.save(user);
	}

	public ArrayList<User> all(){
		return (ArrayList<User>)userRepository.findAll();
	}

	public User findById(long id){
		return userRepository.findOne(id);
	}

	public void destroy(long id){
		userRepository.delete(id);
	}
}
