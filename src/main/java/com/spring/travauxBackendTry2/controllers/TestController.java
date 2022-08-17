package com.spring.travauxBackendTry2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.travauxBackendTry2.entities.Utilisateur;
import com.spring.travauxBackendTry2.services.IUtilisateurService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	@Autowired
	IUtilisateurService uService;
	
	 @PostMapping("/add-user")
		@ResponseBody
		public void addUser(@RequestBody Utilisateur user) {
	    	uService.addUser(user);
		}
	 @GetMapping("/get-all-users")
	 	@ResponseBody
	 	public List<Utilisateur> getUsers()
	 	{
	 	    List<Utilisateur> listUsers = uService.getAllusers();
	 	    return listUsers;
	 	}
	 
	// http://localhost:8082/utilisateur/modify-user
//	 	@PutMapping("/modify-user")
//	 	@ResponseBody
//	 	public Utilisateur modifyUser(@RequestBody Utilisateur u)
//	 	{
//	 		return uService.updateUser(u);
//	 	}
	 	
	 	// http://localhost:8082/utilisateur/get-user/1
	 	@GetMapping("/get-user/{user-id}")
	 	@ResponseBody
	 	public Utilisateur getUser(@PathVariable("user-id") Long id) 
	 	{
	 		return uService.getUserById(id);
	 	}
	
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('TECHNICIEN') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/tech")
	@PreAuthorize("hasRole('TECHNICIEN')")
	public String technicienAccess() {
		return "Technicien Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
}