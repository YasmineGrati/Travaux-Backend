package com.spring.travauxBackendTry2.services;

import java.util.List;

import com.spring.travauxBackendTry2.entities.Utilisateur;


public interface IUtilisateurService {
	
	List<Utilisateur> getAllusers();
	
	public void addUser (Utilisateur user);

	void deleteUser(Long id);

	void updateUser(Utilisateur u);

	Utilisateur getUserById(Long id);
	
}