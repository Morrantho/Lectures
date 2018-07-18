package com.project.login.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
public class CustomerOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="orders_products",
		joinColumns=@JoinColumn(name="order_id"),
		inverseJoinColumns=@JoinColumn(name="product_id")
	)
	private List<Product> products;

	@ManyToOne(fetch=FetchType.LAZY)
	private Customer customer;
	
	public CustomerOrder(){
		products = new ArrayList<Product>();
	}
	

	// Getters And Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
