package com.spring.travauxBackendTry2.services;

import java.util.List;

import com.spring.travauxBackendTry2.entities.Adresse;

public interface IAdresseService {
	
	List<Adresse> getAllAdresses();

	Adresse addAdresse(Adresse a);
	
	void deleteAdresse(Long id);

	Adresse updateAdresse(Adresse a);

	Adresse getAdresseById(Long id);
}