package com.spring.travauxBackendTry2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.travauxBackendTry2.entities.Historique;

@Repository
public interface IHistoriqueRepository extends JpaRepository<Historique, Long> {

}