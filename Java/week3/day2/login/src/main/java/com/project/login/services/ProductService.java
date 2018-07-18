package com.project.login.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.project.login.repositories.ProductRepository;
import com.project.login.models.Product;

@Service
public class ProductService {
    private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
    }
    
    public List<Product> all(){
		return (List<Product>) productRepository.findAll();
	} 

	public void create(Product product){
		productRepository.save(product);
	}        

    public Product findOne(Long id) {
		return (Product)productRepository.findOne(id);
	}
    
    public void destroy(Long id){
		productRepository.delete(id);
    }
    
	public void update(Product product){
		productRepository.save(product);
	}

}