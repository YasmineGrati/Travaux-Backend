package com.spring.travauxBackendTry2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.travauxBackendTry2.entities.Travaux;

@Repository
public interface ITravauxRepository  extends JpaRepository<Travaux, Long> {
	@Query(value="select * from utilisateur u join utilisateur_travaux ut on ut.techniciens_id_utilisateur =u.id_utilisateur \r\n"
			+ "join travaux t on t.id_travaux = ut.travaux_id_travaux where ut.techniciens_id_utilisateur = :TechnicienId" ,nativeQuery = true)
	List<Travaux> listerTravaux(@Param("TechnicienId") Long TechnicienId);
	
	
	
}