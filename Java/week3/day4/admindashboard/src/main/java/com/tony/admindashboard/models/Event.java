package com.tony.admindashboard.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Event {
	@Id
	@GeneratedValue
	private long id;
	
	@Size(min=1,max=255)
	private String name;
		
	private String date;

	private String city;

	private String state;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "users_events",
		joinColumns = @JoinColumn(name = "event_id"),
		inverseJoinColumns = @JoinColumn(name = "user_id")
	)
	private List<User> users;

	private String host;

	@OneToMany(mappedBy="event",fetch=FetchType.LAZY)
	private List<Comment> comments;

	public void setId(long id){this.id=id;}
	public long getId(){return id;}

	public void setName(String name){this.name=name;}
	public String getName(){return name;}

	public void setDate(String date){this.date=date;}
	public String getDate(){return date;}

	public void setCity(String city){this.city=city;}
	public String getCity(){return city;}

	public void setState(String state){this.state=state;}
	public String getState(){return state;}

	public Event(){

	}

	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	/**
	 * @return the comments
	 */
	public List<Comment> getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}
	/**
	 * @param users the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}
}
