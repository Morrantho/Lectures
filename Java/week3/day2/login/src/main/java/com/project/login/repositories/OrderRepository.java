package com.project.login.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.project.login.models.CustomerOrder;

@Repository
public interface OrderRepository extends CrudRepository<CustomerOrder,Long>{
    List<CustomerOrder> findAll();

}