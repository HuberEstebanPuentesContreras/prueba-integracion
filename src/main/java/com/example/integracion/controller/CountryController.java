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

import com.example.integracion.entity.Country;
import com.example.integracion.services.CountryService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/security/country")
public class CountryController {

	@Autowired
    private CountryService service;

    @GetMapping
    public List<Country> all() {
        return service.all();
    }

    @GetMapping("{id}")
    public Optional<Country> show(@PathVariable Short id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Country save(@RequestBody Country country) {
        return service.save(country);
    }

    @PutMapping("{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Country update(@PathVariable Short id, @RequestBody Country country) {
        Optional<Country> op = service.findById(id);

        if (op.isPresent()) {
            Country countryToUpdate = op.get();
            countryToUpdate.setCountry(country.getCountry());
            return service.save(countryToUpdate);
        }

        return country;
    }
    
}
