package com.project.portfolio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.portfolio.models.User;

@Repository 												
public interface UserRepository extends CrudRepository<User,Long>{
}
