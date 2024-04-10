package com.example.integracion.iServices;

import java.util.List;
import java.util.Optional;

import com.example.integracion.entity.Language;

public interface ILanguageService {

	List<Language> all();
	
	Optional<Language> findById(Byte id);
	
	Language save(Language language);
	
}
