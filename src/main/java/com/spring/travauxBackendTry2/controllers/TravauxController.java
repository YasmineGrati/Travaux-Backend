package com.spring.travauxBackendTry2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.travauxBackendTry2.entities.Travaux;
import com.spring.travauxBackendTry2.entities.Utilisateur;
import com.spring.travauxBackendTry2.services.ITravauxService;


@RestController
@RequestMapping("travaux")
@CrossOrigin(origins = "http://localhost:4200")
public class TravauxController {
	
	@Autowired
	ITravauxService tService;
	
	// http://localhost:8082/travaux/add-travaux
    @PostMapping("/add-travaux")
	@ResponseBody
	public void addTravaux (@RequestBody Travaux t){
    	tService.addTravaux(t);
	}
    
    // http://localhost:8082/travaux/get-all-travaux
    @GetMapping("/get-all-travaux")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Travaux>> getAllTravaux()
    {
    	return ResponseEntity.status(200).body(tService.getAllTravaux());
    }
    
 	// http://localhost:8081/travaux/delete-travaux/{travaux-id}
 	@DeleteMapping("/delete-travaux/{travaux-id}")
 	@ResponseBody
 	public void deleteTravaux(@PathVariable("travaux-id") Long id)
 	{
 		tService.deleteTravaux(id);
 	}
 	
 	// http://localhost:8081/travaux/modify-travaux
 	@PutMapping("/modify-travaux")
 	@ResponseBody
 	public Travaux modifyTravaux(@RequestBody Travaux t)
 	{
 		return tService.updateTravaux(t);
 	}
 	
 	// http://localhost:8081/travaux/get-travaux/1
 	@GetMapping("/get-travaux/{travaux-id}")
 	@ResponseBody
 	public Travaux getTravaux(@PathVariable("travaux-id") Long id) 
 	{
 		return tService.getTravauxById(id);
 	}
 	
    // http://localhost:8081/travaux/affecter-travaux-technicien/2/6
  	@GetMapping("/affecter-travaux-technicien/{travaux-id}/{technicien-id}")
  	@ResponseBody
 	public void affecterTravauxToTechnicien(@PathVariable("travaux-id") Long TravauxId,@PathVariable("technicien-id") Long TechnicienId) {
  		tService.affecterTravauxToTechnicien(TravauxId, TechnicienId);
  	}
  	
  	//http://localhost:8082/travaux/Techncien-affecter/2
  	@GetMapping("/Techncien-affecter/{travaux-id}")
  	@ResponseBody
 	public List<Utilisateur> technicienAffecter(@PathVariable("travaux-id") Long TravauxId) {
  		return tService.chercherTechnicien(TravauxId);
  	}
  	
    // http://localhost:8081/travaux/get-travaux-By-Technicien/1
  	@GetMapping("/get-travaux-By-Technicien/{technicien-id}")
  	@ResponseBody
	public List<Travaux> getTravauxByTechnicien(@PathVariable("technicien-id") Long TechnicienId)
  	{
  		return tService.getTravauxByTechnicien(TechnicienId);
  	}
  	
 // http://localhost:8081/travaux/affecter-historique-travaux/2/1
   	@PutMapping("/affecter-historique-travaux/{historique-id}/{travaux-id}")
   	@ResponseBody
  	public void affecterHistoriqueATravaux(@PathVariable("historique-id")Long hisId, @PathVariable("travaux-id") Long TravauxId) {
   		tService.affecterHistoriqueATravaux(hisId, TravauxId);
   	}

}