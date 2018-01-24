	package com.project.many.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.many.repositories.CatProRepository;

import com.project.many.models.Category;
import com.project.many.models.Product;
import com.project.many.models.CategoryProduct;

import com.project.many.services.CategoryService;
import com.project.many.services.ProductService;


@Service
public class CatProService{
	private CatProRepository catProRepository;
	private CategoryService catService;
	private ProductService proService;

	public CatProService(CatProRepository catProRepository,CategoryService catService,ProductService proService){
		this.catProRepository=catProRepository;
		this.catService=catService;
		this.proService=proService;
	}

	public void join(long category_id,long product_id){
		Category cat = catService.findById(category_id);
		Product pro = proService.findById(product_id);

		CategoryProduct entry = new CategoryProduct(pro,cat);
		catProRepository.save( entry );
	}
}
