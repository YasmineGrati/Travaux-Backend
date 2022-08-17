package com.spring.travauxBackendTry2.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.travauxBackendTry2.entities.ERole;
import com.spring.travauxBackendTry2.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}