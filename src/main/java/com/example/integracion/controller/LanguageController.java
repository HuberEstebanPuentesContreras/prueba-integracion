package com.example.integracion.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.integracion.entity.Language;
import com.example.integracion.services.LanguageService;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping("api/security/language")
public class LanguageController {

	@Autowired
	private LanguageService service;
	
	@GetMapping
	public List<Language> all() {
		return service.all();
	}
	
	@GetMapping("{id}")
	public Optional<Language> show(@PathVariable Byte id){
		return service.findById(id);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Language save(@RequestBody Language language) {
		return service.save(language);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Language update(@PathVariable Byte id, @RequestBody Language language) {
		Optional<Language> op = service.findById(id);
		
		if (op.isPresent()) {
			Language languageToUpdate = op.get();
			languageToUpdate.setName(language.getName());
			return service.save(languageToUpdate);
		}
		
		return language;
	}
	
}
