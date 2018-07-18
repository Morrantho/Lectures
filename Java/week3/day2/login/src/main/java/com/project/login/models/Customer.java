package com.project.login.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Size;
import com.project.login.models.CustomerOrder;

@Entity
public class Customer {
	@Id
	@GeneratedValue
	private Long id;
	
	@Size(min=1,max=255,message="Name cannot be blank.")
	private String name;

	@OneToMany(fetch=FetchType.LAZY,mappedBy="customer")
	private List<CustomerOrder> orders;

	@Column(updatable=false)
	private Date createdAt;	
	
	@Column(updatable=false)
	private Date updatedAt;
	
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

	@PrePersist
	protected void onCreate(){
		createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		updatedAt = new Date();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Customer(){
		
	}
	public List<CustomerOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<CustomerOrder> orders) {
		this.orders = orders;
	}
}
