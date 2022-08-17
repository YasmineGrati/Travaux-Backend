package com.spring.travauxBackendTry2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.travauxBackendTry2.entities.Historique;
import com.spring.travauxBackendTry2.entities.Travaux;
import com.spring.travauxBackendTry2.repositories.IHistoriqueRepository;
import com.spring.travauxBackendTry2.repositories.ITravauxRepository;



@Service
public class HistoriqueServiceImpl implements IHistoriqueService {

	@Autowired
	IHistoriqueRepository hRepository;
	@Autowired
	ITravauxRepository tRepository;

	@Override
	public List<Historique> getAllHistoriques() {
		List<Historique> listHistoriques = (List<Historique>) hRepository.findAll();
		return listHistoriques;
	}

	@Override
	public Historique addHistorique(Historique h) {
		return hRepository.save(h);
	}

	@Override
	public void deleteHistorique(Long id) {
		hRepository.deleteById(id);
	}

	@Override
	public Historique updateHistorique(Historique h) {
		return hRepository.save(h);
	}

	@Override
	public Historique getHistoriqueById(Long id) {
		return hRepository.findById(id).orElse(null);
	}

	@Override
	public void ajouterEtaffecterListeHistoriques(List<Historique> listeHistoriques, Long idTravaux) {
		Travaux travaux = tRepository.findById(idTravaux).orElse(null);
		for(Historique historique : listeHistoriques) {
			historique.setTravaux(travaux);
			hRepository.save(historique);
		}
	}
	
}