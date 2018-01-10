package com.project.categories_products.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.categories_products.models.CategoryProduct;

@Repository 												
public interface CategoryProductRepository extends CrudRepository<CategoryProduct,Long>{

}
