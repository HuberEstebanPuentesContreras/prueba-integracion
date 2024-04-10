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
@Table(name = "language")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Language {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "language_id")
    private Byte languageId;

    @Column(name = "name", length = 20)
    private String name;
    
}
