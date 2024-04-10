package com.example.integracion.iRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.integracion.entity.Country;

public interface ICountryRepository extends JpaRepository<Country, Short>{

}
