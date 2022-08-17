package com.spring.travauxBackendTry2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.travauxBackendTry2.entities.Utilisateur;
import com.spring.travauxBackendTry2.repositories.UserRepository;
import com.spring.travauxBackendTry2.services.IUtilisateurService;


@RestController
@RequestMapping("utilisateur")
@CrossOrigin(origins = "http://localhost:4200")
public class UtilisateurController {

	@Autowired
	IUtilisateurService uService;
	@Autowired
	UserRepository uRepository;
    
    // http://localhost:8082/utilisateur/add-user
    @PostMapping("/add-user")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> addUser(@RequestParam String username,@RequestParam String email,
    		@RequestParam String password,@RequestParam String villeProfession,@RequestParam Integer numTel,
            @RequestParam String nom,@RequestParam String prenom,@RequestParam Boolean active )
    {
    	Utilisateur user = new Utilisateur(nom, prenom, numTel, villeProfession, active, username, email, password);
        if (uRepository.existsByUsername(user.getUsername())) {
            return ResponseEntity
                    .ok()
                    .body("Error: Username is already taken!");
        }
     else{
        if (uRepository.existsByEmail(user.getEmail())) {
            return ResponseEntity
                    .ok()
                    .body("Error: Email is already in use!");
        }
        else{
        uService.addUser(user);
        return ResponseEntity.ok().body("User created");}}

    }
    
    // http://localhost:8082/utilisateur/get-all-users
    @GetMapping("/get-all-users")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Utilisateur>> getAllusers()
    {
    	return ResponseEntity.status(200).body(uService.getAllusers());
    }
    
    // http://localhost:8082/utilisateur/modify-user
    @PutMapping("/modify-user")
	public ResponseEntity<?> modifyUser(@RequestBody Utilisateur user)
    {
    	uService.updateUser(user);
	    return new ResponseEntity<>(HttpStatus.OK);
	}
    
    // http://localhost:8082/utilisateur/1
    @GetMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Utilisateur> getUserById(@PathVariable Long id) {
    	Utilisateur user = new Utilisateur();
    	Utilisateur user2 = new Utilisateur();
        user = uService.getUserById(id);
        user2.setId(user.getId());
        user2.setEmail(user.getEmail());
        user2.setNom(user.getNom());
        user2.setPrenom(user.getPrenom());
        user2.setNumTel(user.getNumTel());
        user2.setUsername(user.getUsername());
        user2.setVilleProfession(user.getVilleProfession());
        user2.setActive(user.getActive());
        user2.setRoles(user.getRoles());
        return ResponseEntity.ok().body(user2);
    }
	 	
 	// http://localhost:8082/utilisateur/delete-user/{user-id}
 	@DeleteMapping("/delete-user/{user-id}")
 	@ResponseBody
 	public void deleteUser(@PathVariable("user-id") Long id)
 	{
 		uService.deleteUser(id);
 	}
 	
}