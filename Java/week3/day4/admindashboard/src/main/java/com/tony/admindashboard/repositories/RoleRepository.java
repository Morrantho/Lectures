package com.tony.admindashboard.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tony.admindashboard.models.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role,Long>{
	public Role findByName(String name);
	public List<Role> findAll();
}
