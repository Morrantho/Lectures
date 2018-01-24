package com.project.many.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.many.repositories.ProductRepository;
import com.project.many.models.Product;

import java.util.ArrayList;

@Service
public class ProductService {
	private ProductRepository productRepository;
		
	public ProductService(ProductRepository productRepository){
		this.productRepository=productRepository;
	}

	public void create(Product p){
		productRepository.save(p);
	}

	public ArrayList<Product> all(){
		return (ArrayList<Product>) productRepository.findAll();
	}

	public Product findById(long id){
		return (Product)productRepository.findOne(id);
	}

	public void destroy(long id){
		productRepository.delete(id);
	}
}
