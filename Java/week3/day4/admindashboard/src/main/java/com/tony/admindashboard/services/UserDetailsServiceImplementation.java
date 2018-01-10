package com.tony.admindashboard.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tony.admindashboard.models.Role;
import com.tony.admindashboard.models.User;
import com.tony.admindashboard.repositories.UserRepository;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService{
	private UserRepository userRepository;

	public UserDetailsServiceImplementation(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	private List<GrantedAuthority> getAuthorities(User user){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for(Role role: user.getRoles()){
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
			authorities.add(grantedAuthority);
		}
		return authorities;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		if(user == null){throw new UsernameNotFoundException("User not found.");}
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),getAuthorities(user));
	}

}
