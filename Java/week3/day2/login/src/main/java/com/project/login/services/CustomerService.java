package com.project.login.services;

import com.project.login.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.project.login.models.Customer;

@Service
public class CustomerService{
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> all(){
		return customerRepository.findAll();
    }
    
    public Customer findOne(Long id) {
		return customerRepository.findOne(id);
	}

	public void create(Customer customer){
		customerRepository.save(customer);
	}

	public void destroy(Long id){
		customerRepository.delete(id);
	}
}	