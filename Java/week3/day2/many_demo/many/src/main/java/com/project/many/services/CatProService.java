package com.project.many.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.many.repositories.CatProRepository;

@Service
public class CatProService{
	private CatProRepository catProRepository;

	public CatProService(CatProRepository catProRepository){
		this.catProRepository=catProRepository;
	}

	public void join(){

	}
}
