package com.project.LanguagesReloaded.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Language{
	@Id
	@GeneratedValue
	private long id;

	@Size(min=1,max=255)
	private String name;

	@Size(min = 1, max = 255)
	private String creator;

	@Size(min=1,max=255)
	private String version;
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date createdAt;
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date updatedAt;

	@PrePersist
	public void onCreate(){this.createdAt = new Date();}
	@PreUpdate
	public void onUpdate(){this.updatedAt = new Date();}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	
	// Setters and Getters go here

	public void setName(String name){
		this.name=name;
	}

	public void setCreator(String creator){
		this.creator=creator;
	}

	public void setVersion(String version){
		this.version=version;
	}
	
	public String getName(){
		return name;
	}

	public String getCreator(){
		return creator;
	}

	public String getVersion(){
		return version;
	}

	public Language(){
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
}
