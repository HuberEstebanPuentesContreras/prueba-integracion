package com.example.integracion.iRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.integracion.entity.Usuarios;

@Repository
public interface IUsuariosRepository extends JpaRepository<Usuarios, Long>{

	Optional<Usuarios> findByUsername(String username);
	
	Boolean existsByUsername(String username);
}
