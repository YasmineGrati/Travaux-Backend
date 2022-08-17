package com.spring.travauxBackendTry2.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.travauxBackendTry2.entities.Utilisateur;
import com.spring.travauxBackendTry2.repositories.ITravauxRepository;
import com.spring.travauxBackendTry2.repositories.UserRepository;

@Transactional
@Service
public class UtilisateurServiceImpl implements IUtilisateurService {
	
	@Autowired
	UserRepository uRepository;
	
	@Autowired
	ITravauxRepository tRepository;
	
	@Autowired
    PasswordEncoder encoder;
	
	@Override
	public List<Utilisateur> getAllusers()
	{
		return uRepository.findAll();
	}
	
	@Override
	public void addUser(Utilisateur user) {
		user.setPassword(encoder.encode(user.getPassword()));
		uRepository.save(user);
	}
	
	@Override
	public void updateUser(Utilisateur u) {
		u.setPassword(encoder.encode(u.getPassword()));
		uRepository.save(u);
	}

	@Override
	public Utilisateur getUserById(Long id) {
		return uRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteUser(Long id) {
		uRepository.deleteById(id);
	}

}