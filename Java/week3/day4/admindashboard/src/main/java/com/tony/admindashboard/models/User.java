package com.tony.admindashboard.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class User {
	@Id
	@GeneratedValue
	private long id;

	@Email
	@Size(min=8)
	private String email;

    @Size(min=8)
    @Type(type="text")
	private String password;
	
	@Transient
	@Size(min=8)
	private String confirm;
	
	@Size(min=1,max=64)
	private String firstName;
	
	@Size(min=1,max=64)
	private String lastName;
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date createdAt;
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date updatedAt;

	private String state;

	@PrePersist
	public void onCreate(){this.createdAt = new Date();}
	@PreUpdate
	public void onUpdate(){this.updatedAt = new Date();}

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="users_roles",
		joinColumns=@JoinColumn(name="user_id"),
		inverseJoinColumns=@JoinColumn(name="role_id")
	)
	private List<Role> roles;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "users_events",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "event_id")
	)
	private List<Event> events;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public boolean isAdmin(){
		for(Role role:this.roles){			
			if(role.getName().equals("ROLE_ADMIN")){return true;}
		}
		return false;
	}
	public boolean isSuperAdmin(){
		for(Role role:this.roles){			
			if(role.getName().equals("ROLE_SUPERADMIN")){return true;}
		}
		return false;
	}
	
	public User(){}
	
	public User(String email,String password,String firstName,String lastName){
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
}
