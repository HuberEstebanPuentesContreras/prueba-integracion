package com.example.integracion.iServices;

import java.util.List;
import java.util.Optional;

import com.example.integracion.entity.Country;

public interface ICountryService {

	List<Country> all();
    
    Optional<Country> findById(Short id);
    
    Country save(Country country);
    
}
