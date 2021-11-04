package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Consommation;
import com.example.demo.model.Equipement;
import com.example.demo.repository.ConsommationRepository;
import com.example.demo.exception.ResourceNotFoundException;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/ecoHome/")
public class ConsommationController {
	
	@Autowired
	ConsommationRepository consommationRepo;
	
	
	/*tous les taches cree
	@RequestMapping("/consommation")
	public List<Consommation> getAllCreatedConsommation()
	{
		List<Consommation> consommations=new ArrayList<>();
		consommationRepo.findAllTaches().forEach(consommations::add);
		return consommations;
	}*/
	
	//trouver les taches d'un employee
	@RequestMapping("/equipement/{id}/consommation")
	public List<Consommation> getAllConsommations(@PathVariable Integer id)
	{
		List<Consommation> consommations=new ArrayList<>();
		consommationRepo.findConsommationbyEquipementId(id).forEach(consommations::add);
		return consommations;
	}
	//trouver tache par id 
	@GetMapping("/consommation/{id}")
	public ResponseEntity<Consommation> getConsommationById(@PathVariable Long id) {
		Consommation consommation = consommationRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Consommation not exist with id :" + id));
		return ResponseEntity.ok(consommation);
	}
	// create tache rest api
	
	@PostMapping("/equipement/{equipementId}/consommation")
	public Consommation createConsommation(@RequestBody Consommation consommation , @PathVariable Integer equipementId) {
		consommation.setEquipement(new Equipement(equipementId));
		return consommationRepo.save(consommation);
	}
	
	@PostMapping("/consommation")
	public Consommation createTache(@RequestBody Consommation consommation) {
		
		return consommationRepo.save(consommation);
	}
	// update tache 
	
	@PutMapping("/consommation/{id}")
	public ResponseEntity<Consommation> updateConsommation(@PathVariable Long id, @RequestBody Consommation consommationDetails){
		Consommation consommation = consommationRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Consommation not exist with id :" + id));
		consommation.setHeure(consommationDetails.getHeure());
		consommation.setMois(consommationDetails.getMois());
		consommation.setJour(consommationDetails.getJour());
		consommation.setQteWattsHeure(consommationDetails.getQteWattsHeure());
		consommation.setQteWattsMois(consommationDetails.getQteWattsMois());
		consommation.setQteWattsJour(consommationDetails.getQteWattsJour()); 
		
		Consommation updatedConsommation = consommationRepo.save(consommation);
		return ResponseEntity.ok(updatedConsommation);
	}
	/*// modifier le statut de la tache
	
	@PutMapping("/Consommation/status/{id}")
	public ResponseEntity<Tache> updateTacheStatuts(@PathVariable Long id){
		Tache tache = consommationRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("employee doesnt exist with id :" + id));
		tache.setTacheStatut("resolu");
		Tache updatedTache = consommationRepo.save(tache);
		return ResponseEntity.ok(updatedTache);
		
	}*/
	
	//delete tache
	// delete employee rest api
		@DeleteMapping("/consommation/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteConsommation(@PathVariable Long id){
			Consommation consommation = consommationRepo.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Consommation not exist with id :" + id));
			
			consommationRepo.delete(consommation);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
		
		/*trouver taches par status
		@RequestMapping("/taches/{bol}")
		public List<Tache> getTachesResolu(@PathVariable Boolean bol)
		{
			List<Tache> taches=new ArrayList<>();
			tacheRepo.findTacheResolu(bol).forEach(taches::add);
			return taches;
		}*/
		/*
		// get all employees
				@GetMapping("/taches/countResolu/{empId}")
				public long countTaches(@PathVariable Long empId) {
					return tacheRepo.countTaches(empId);
				}
				
				
				@GetMapping("/taches/countAffectees/{empId}")
				public long countTachesAffectees(@PathVariable Long empId) {
					return tacheRepo.countTachesAffectees(empId);
				}
				
		*/
		
}
