package com.project.LanguagesReloaded.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.LanguagesReloaded.repositories.LanguageRepository;
import com.project.LanguagesReloaded.models.Language;

@Service
public class LanguageService {
	private LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository){
		this.languageRepository=languageRepository;
	}

	public void create(Language language){
		languageRepository.save(language);
	}

	public ArrayList<Language> all(){
		return (ArrayList<Language>) languageRepository.findAll();
	}

	public Language findById(long id){
		return (Language) languageRepository.findOne(id);
	}

	public void update(Language language){
		languageRepository.save(language);
	}

	public void destroy(long id){
		languageRepository.delete(id);
	}
}
