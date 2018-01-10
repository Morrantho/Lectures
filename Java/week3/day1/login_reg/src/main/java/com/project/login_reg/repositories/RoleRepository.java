package com.project.login_reg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.login_reg.models.Role;

@Repository 												
public interface RoleRepository extends CrudRepository<Role,Long>{
		
}
