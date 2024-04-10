package com.example.integracion.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.integracion.entity.Country;
import com.example.integracion.iRepository.ICountryRepository;
import com.example.integracion.iServices.ICountryService;

@Service
public class CountryService implements ICountryService{

	@Autowired
	private ICountryRepository repository;
	
	@Override
	public List<Country> all(){
		return repository.findAll();
	}
	
	@Override
	public Optional<Country> findById(Short id){
		return repository.findById(id);
	}
	
	@Override
	public Country save(Country country) {
		return repository.save(country);
	}
	
}
