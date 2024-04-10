package com.example.integracion.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "country")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "country_id")
    private Short countryId;

    @Column(name = "country", length = 50)
    private String country;
    
}
