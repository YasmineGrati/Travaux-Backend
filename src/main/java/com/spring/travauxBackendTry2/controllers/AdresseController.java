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

import com.spring.travauxBackendTry2.entities.Adresse;
import com.spring.travauxBackendTry2.services.IAdresseService;

@RestController
@RequestMapping("adresse")
public class AdresseController {
	
	@Autowired
	IAdresseService  aService;
	
	// http://localhost:8081/adresse/add-adresse
    @PostMapping("/add-adresse")
	@ResponseBody
	public Adresse addAdresse(@RequestBody Adresse a)
	{
    	Adresse adresse = aService.addAdresse(a);
    	return adresse;
	}
    
    // http://localhost:8081/adresse/get-all-adresses
    @GetMapping("/get-all-adresses")
 	@ResponseBody
    public List<Adresse> getAllAdresses()
    {
    	List<Adresse> listAdresses = aService.getAllAdresses();
 	    return listAdresses;
    }
    
 	// http://localhost:8081/adresse/delete-adresse/{adresse-id}
 	@DeleteMapping("/delete-adresse/{adresse-id}")
 	@ResponseBody
 	public void deleteAdresse(@PathVariable("adresse-id") Long id)
 	{
 		aService.deleteAdresse(id);
 	}
 	
 	// http://localhost:8081/adresse/modify-adresse
 	@PutMapping("/modify-adresse")
 	@ResponseBody
 	public Adresse modifyAdresse(@RequestBody Adresse a)
 	{
 		return aService.updateAdresse(a);
 	}
 	
 	// http://localhost:8081/adresse/get-adresse/1
 	@GetMapping("/get-adresse/{adresse-id}")
 	@ResponseBody
 	public Adresse getAdresse(@PathVariable("adresse-id") Long id) 
 	{
 		return aService.getAdresseById(id);
 	}

}