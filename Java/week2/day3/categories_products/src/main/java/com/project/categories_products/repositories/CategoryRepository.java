package com.project.categories_products.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.project.categories_products.models.Category;

import java.util.List;

@Repository 												
public interface CategoryRepository extends CrudRepository<Category,Long>{

	// @Query(value="SELECT * FROM categories_products JOIN category ON category.id=categories_products.category_id JOIN product ON product.id=categories_products.product_id",nativeQuery=true)
	// public List<Object> join();
}
