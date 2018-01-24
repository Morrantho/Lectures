package com.project.many.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.many.repositories.CategoryRepository;
import com.project.many.models.Category;

import java.util.ArrayList;

@Service
public class CategoryService {
	private CategoryRepository categoryRepository;
		
	public CategoryService(CategoryRepository categoryRepository){
		this.categoryRepository=categoryRepository;
	}
	
	public void create(Category cat){
		categoryRepository.save(cat);
	}

	public ArrayList<Category> all(){
		return (ArrayList<Category>)categoryRepository.findAll();
	}

	public Category findById(long id){
		return (Category)categoryRepository.findOne(id);
	}

	public void destroy(long id){
		categoryRepository.delete(id);
	}
}
