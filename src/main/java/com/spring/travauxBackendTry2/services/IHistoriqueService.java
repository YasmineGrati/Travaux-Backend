package com.spring.travauxBackendTry2.services;

import java.util.List;

import com.spring.travauxBackendTry2.entities.Historique;


public interface IHistoriqueService {
	
	List<Historique> getAllHistoriques();

	Historique addHistorique(Historique h);

	void deleteHistorique(Long id);

	Historique updateHistorique(Historique h);

	Historique getHistoriqueById(Long id);
	
	void ajouterEtaffecterListeHistoriques(List<Historique> listeHistoriques, Long idTravaux);
	
}