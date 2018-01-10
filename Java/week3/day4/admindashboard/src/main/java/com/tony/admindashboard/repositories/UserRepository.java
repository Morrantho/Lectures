package com.tony.admindashboard.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tony.admindashboard.models.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{
	public User findByEmail(String email);
}
