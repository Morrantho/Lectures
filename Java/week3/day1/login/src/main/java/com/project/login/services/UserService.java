package com.project.login.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.login.models.User;
import com.project.login.repositories.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
	private BCryptPasswordEncoder bcrypt;

	public UserService(UserRepository userRepository){
		this.userRepository=userRepository;
		this.bcrypt=new BCryptPasswordEncoder();
	}
	
	public boolean isMatch(String password,String dbPass){
		if( bcrypt.matches(password,dbPass) ){
			return true;
		}else{
			return false;
		}
	}

	public void create(User user){
		user.setPassword(  bcrypt.encode( user.getPassword() ) );
		userRepository.save(user);
	}

	public void update(User user){
		create(user);
	}

	public ArrayList<User> all(){
		return (ArrayList<User>)userRepository.findAll();
	}

	public User findById(long id){
		return (User) userRepository.findOne(id);
	}

	public void destroy(User user){
		userRepository.delete(user);
	}

	public User findByEmail(String email){
		return (User) userRepository.findByEmail(email);
	}
}
