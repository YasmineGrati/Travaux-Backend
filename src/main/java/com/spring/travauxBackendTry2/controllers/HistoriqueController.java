package com.spring.travauxBackendTry2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.travauxBackendTry2.entities.Historique;
import com.spring.travauxBackendTry2.services.IHistoriqueService;
import com.spring.travauxBackendTry2.services.ITravauxService;

@RestController
@RequestMapping("historique")
public class HistoriqueController {

	@Autowired
	IHistoriqueService hService;
	@Autowired
	ITravauxService tService;

	// http://localhost:8081/historique/add-historique
	@PostMapping("/add-historique")
	@ResponseBody
	public Historique addAdresse(@RequestBody Historique h) {
		Historique historique = hService.addHistorique(h);
		return historique;
	}

	// http://localhost:8081/historique/modify-Historique
	@PutMapping("/modify-Historique")
	@ResponseBody
	public Historique modifyHistorique(@RequestBody Historique h) {
		return hService.updateHistorique(h);
	}

	// http://localhost:8081/historique/get-all-historiques
	@GetMapping("/get-all-historiques")
	@ResponseBody
	public List<Historique> getAllHistoriques() {
		List<Historique> listHistoriques = hService.getAllHistoriques();
		return listHistoriques;
	}

	// http://localhost:8081/historique/delete-historique/{historique-id}
	@DeleteMapping("/delete-historique/{historique-id}")
	@ResponseBody
	public void deleteHistorique(@PathVariable("historique-id") Long id) {
		hService.deleteHistorique(id);
	}

	// http://localhost:8081/historique/get-historique/1
	@GetMapping("/get-historique/{historique-id}")
  	@ResponseBody
  	public Historique getHistorique(@PathVariable("historique-id") Long id){
  		return hService.getHistoriqueById(id);
  	}

	// http://localhost:8081/historique/get-historique/1
	@PostMapping("/affecter-historique-travaux/{travaux-id}")
  	@ResponseBody
  	public void ajouterEtaffecterListeHistoriques(@RequestBody List<Historique> listeHistoriques, @PathVariable("travaux-id") Long idTravaux)
	{
  		hService.ajouterEtaffecterListeHistoriques(listeHistoriques, idTravaux);
  	}
  	
}