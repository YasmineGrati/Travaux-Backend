package com.spring.travauxBackendTry2.services;

import java.util.List;

import com.spring.travauxBackendTry2.entities.Travaux;
import com.spring.travauxBackendTry2.entities.Utilisateur;

public interface ITravauxService {

	List<Travaux> getAllTravaux();

	public void addTravaux(Travaux t);

	void deleteTravaux(Long id);

	Travaux updateTravaux(Travaux t);

	Travaux getTravauxById(Long id);

	public void affecterTravauxToTechnicien(Long TravauxId, Long TechnicienId);

	public List<Travaux> getTravauxByTechnicien(Long TechnicienId);
		
	void affecterHistoriqueATravaux(Long hisId, Long TravauxId);

	List<Utilisateur> chercherTechnicien(Long travauxId);

}