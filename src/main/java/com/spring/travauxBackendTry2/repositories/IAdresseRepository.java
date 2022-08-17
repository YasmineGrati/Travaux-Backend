package com.spring.travauxBackendTry2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.travauxBackendTry2.entities.Adresse;

@Repository
public interface IAdresseRepository extends JpaRepository<Adresse, Long> {

//	Adresse findByAdresse(String adresse);
	@Query("Select ad From Adresse ad where ad.adresse = :adressevoulu")
	List<Adresse> findByAdresse(@Param("adressevoulu") String adresse);
}