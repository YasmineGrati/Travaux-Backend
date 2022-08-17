package com.spring.travauxBackendTry2.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.travauxBackendTry2.entities.Adresse;
import com.spring.travauxBackendTry2.entities.Historique;
import com.spring.travauxBackendTry2.entities.Travaux;
import com.spring.travauxBackendTry2.entities.Utilisateur;
import com.spring.travauxBackendTry2.repositories.IAdresseRepository;
import com.spring.travauxBackendTry2.repositories.IHistoriqueRepository;
import com.spring.travauxBackendTry2.repositories.ITravauxRepository;
import com.spring.travauxBackendTry2.repositories.UserRepository;


@Service
public class TravauxServiceImpl implements ITravauxService {

	@Autowired
	ITravauxRepository tRepository;
	@Autowired
	UserRepository uRepository;
	@Autowired
	IHistoriqueRepository hRepository;
	@Autowired
	IAdresseRepository aRepository;
	
	@Override
	public List<Travaux> getAllTravaux() {
		List<Travaux> listTravaux =  tRepository.findAll();
		return listTravaux;
	}
	
	@Override
	@Transactional
	public void addTravaux(Travaux t) {
		
		System.out.println("test trqvqux ");
		System.out.println("testt :"+t.getAdresse().getAdresse());
		
		if(aRepository.findByAdresse(t.getAdresse().getAdresse()).isEmpty()) {
			Adresse a = aRepository.save(t.getAdresse());
			t.setAdresse(a);
			}
		else t.setAdresse(aRepository.findByAdresse(t.getAdresse().getAdresse()).get(0));
		tRepository.save(t);
	}

	@Override
	public void deleteTravaux(Long id) {
		tRepository.deleteById(id);		
	}

	@Override
	public Travaux updateTravaux(Travaux t) {
		return tRepository.save(t);
	}
	
	@Override
	public Travaux getTravauxById(Long id) {
		return tRepository.findById(id).orElse(null);
	}

	@Override
	public void affecterTravauxToTechnicien(Long TravauxId, Long TechnicienId) {
		Utilisateur technicien = uRepository.findById(TechnicienId).orElse(null);
		Travaux travaux = tRepository.findById(TravauxId).orElse(null);
		if(travaux != null) technicien.getTravaux().add(travaux);
		uRepository.save(technicien);
	}

	@Override
	public List<Travaux> getTravauxByTechnicien(Long TechnicienId) {
		
				List<Travaux> l= tRepository.listerTravaux(TechnicienId);
				return l;
	}

	@Override
	public void affecterHistoriqueATravaux(Long hisId, Long TravauxId) {
		Travaux travaux = tRepository.findById(TravauxId).get();
		Historique historique = hRepository.findById(hisId).get();
		historique.setTravaux(travaux);
		hRepository.save(historique);
	}

	@Override
	public List<Utilisateur> chercherTechnicien(Long travauxId) {
		Travaux trav = tRepository.findById(travauxId).get();
		return trav.getTechniciens();
	}
	
}