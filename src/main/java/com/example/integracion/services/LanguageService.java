package com.example.integracion.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.integracion.entity.Language;
import com.example.integracion.iRepository.ILanguageRepository;
import com.example.integracion.iServices.ILanguageService;

@Service
public class LanguageService implements ILanguageService{

	@Autowired
	private ILanguageRepository repository;
	
	@Override
	public List<Language> all(){
		return repository.findAll();
	}
	
	@Override
	public Optional<Language> findById(Byte id){
		return repository.findById(id);
	}
	
	@Override
	public Language save(Language language) {
		return repository.save(language);
	}
	
}
