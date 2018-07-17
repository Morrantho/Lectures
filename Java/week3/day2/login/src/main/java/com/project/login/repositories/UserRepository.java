package com.project.login.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.project.login.models.User;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{
	User findByEmail(String email);
	User findByUsername(String username);
}