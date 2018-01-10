package com.project.categories_products.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.project.categories_products.models.CategoryProduct;
import com.project.categories_products.repositories.CategoryProductRepository;

@Service
public class CategoryProductService {
	private CategoryProductRepository categoryProductRepository;
	
	public CategoryProductService(CategoryProductRepository categoryProductRepository){
		this.categoryProductRepository=categoryProductRepository;
	}

	public ArrayList<CategoryProduct> all(){
		return (ArrayList<CategoryProduct>)categoryProductRepository.findAll();
	}
}
