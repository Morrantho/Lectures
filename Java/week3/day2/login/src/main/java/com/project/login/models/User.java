package com.project.login.models;
import javax.validation.constraints.Size;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.hibernate.validator.constraints.Email;

@Entity
public class User{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	public void setId(Long id){
		this.id=id;
	}
	public Long getId(){
		return id;
	}

	@Size(min=1,max=255,message="First name is required.")
	private String first;
	public void setFirst(String first){
		this.first = first;
	}
	public String getFirst(){
		return first;
	}

	@Size(min=1,max=255,message="Last name is required.")
	private String last;
	public void setLast(String last){
		this.last=last;
	}
	public String getLast(){
		return last;
	}

	@Email(message="Invalid Email Format")
	private String email;
	public void setEmail(String email){
		this.email=email;
	}
	public String getEmail(){
		return email;
	}

	@Size(min=1,max=255,message="Username is required")
	private String username;
	public void setUsername(String username){
		this.username=username;
	}
	public String getUsername(){
		return username;
	}

	@Size(min=8,max=255,message="Password must be between 8-255")
	private String password;
	public void setPassword(String password){
		this.password=password;
	}
	public String getPassword(){
		return password;
	}

	public User(){

	}

	public User(String first,String last,String email,String username,String password){
		this.first=first;
		this.last=last;
		this.email=email;
		this.username=username;
		this.password=password;
	}
}