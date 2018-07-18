package com.project.login.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.project.login.models.CustomerOrder;

@Entity
public class Product{

	@Id 
	@GeneratedValue
	private Long id;

	@Size(min=1,max=255,message="Product name is required!")
	private String name;

	@Size(min=1,max=255,message="Product Image is required!")
	private String img;

	@Size(min=1,max=255,message="Product Description is required!")
	private String description;

	@NotNull(message="Quantity is required!")
	private int quantity;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="orders_products",
		joinColumns=@JoinColumn(name="product_id"),
		inverseJoinColumns=@JoinColumn(name="order_id")
	)
	private List<CustomerOrder> orders;	
	
	public List<CustomerOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<CustomerOrder> orders) {
		this.orders = orders;
	}

	public Product() {
	}
	
	public Product(String name,String img,String description,int quantity) {
		this.name=name;
		this.img=img;
		this.description=description;
		this.quantity=quantity;
	}

	// Getters and Setters

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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
