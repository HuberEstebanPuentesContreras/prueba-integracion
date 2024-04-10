package com.example.integracion.iRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.integracion.entity.Language;

public interface ILanguageRepository extends JpaRepository<Language, Byte>{

}
