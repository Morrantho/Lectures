package com.project.login.services;

import com.project.login.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.project.login.models.CustomerOrder;

@Service
public class OrderService{
	@Autowired
    private OrderRepository cor;
    
    public List<CustomerOrder> all(){
		return cor.findAll();
    }
    
    public void create(CustomerOrder customerOrder){
		cor.save(customerOrder);
	}
}