package com.project.LanguagesReloaded.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.project.LanguagesReloaded.models.Language;

@Repository 												
public interface LanguageRepository extends CrudRepository<Language,Long>{

}
