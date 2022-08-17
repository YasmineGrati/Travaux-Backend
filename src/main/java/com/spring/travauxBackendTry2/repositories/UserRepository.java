package com.spring.travauxBackendTry2.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.travauxBackendTry2.entities.Utilisateur;

@Repository
public interface UserRepository extends JpaRepository<Utilisateur, Long>{
	Optional<Utilisateur> findByUsername(String username);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
	
}