package com.project.pets.services;

import java.util.ArrayList;
import java.util.List;

// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.pets.repositories.PetRepository;
import com.project.pets.models.Pet;

@Service
public class PetService {
	private PetRepository petRepository;
		
	public PetService(PetRepository petRepository){
		this.petRepository = petRepository;
	}
	
	public void create(Pet Pet){
		petRepository.save(Pet);
	}

	public ArrayList<Pet> all(){
		return (ArrayList<Pet>)petRepository.findAll();
	}

	public Pet findById(long id){
		return petRepository.findOne(id);
	}

	public void destroy(long id){
		petRepository.delete(id);
	}
}
