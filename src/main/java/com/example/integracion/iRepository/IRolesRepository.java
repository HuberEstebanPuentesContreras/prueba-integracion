package com.example.integracion.iRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.integracion.entity.Roles;

@Repository
public interface IRolesRepository extends JpaRepository<Roles, Long>{

	Optional<Roles> findByName(String name);
}
