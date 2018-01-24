package com.project.many.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.many.models.CategoryProduct;

@Repository 												
public interface CatProRepository extends CrudRepository<CategoryProduct,Long>{
}
