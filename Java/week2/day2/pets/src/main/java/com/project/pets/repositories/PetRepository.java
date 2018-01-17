package com.project.pets.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.pets.models.Pet;

@Repository 												
public interface PetRepository extends CrudRepository<Pet,Long>{

}
