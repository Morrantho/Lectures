package com.project.login.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.project.login.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long>{
    List<Product> findAll();
}