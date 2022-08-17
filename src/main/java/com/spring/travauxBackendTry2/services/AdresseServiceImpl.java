package com.spring.travauxBackendTry2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.travauxBackendTry2.entities.Adresse;
import com.spring.travauxBackendTry2.repositories.IAdresseRepository;

@Service
public class AdresseServiceImpl implements IAdresseService {
	
	@Autowired
	IAdresseRepository aRepository;

	@Override
	public List<Adresse> getAllAdresses() {
		List<Adresse> listAdresses = (List<Adresse>) aRepository.findAll();
		return listAdresses;
	}

	@Override
	public Adresse addAdresse(Adresse a) {
		return aRepository.save(a);
	}

	@Override
	public void deleteAdresse(Long id) {
		aRepository.deleteById(id);
	}

	@Override
	public Adresse updateAdresse(Adresse a) {
		return aRepository.save(a);
	}

	@Override
	public Adresse getAdresseById(Long id) {
		return aRepository.findById(id).orElse(null);
	}

}