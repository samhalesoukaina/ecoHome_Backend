package com.example.demo.controller;

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

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Equipement;
import com.example.demo.repository.EquipementRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/ecoHome/")
public class EquipementController {

	@Autowired
	private EquipementRepository equipementRepository;
	
	// get all Equipements
	@GetMapping("/equipements")
	public List<Equipement> getAllEquipements(){
		return equipementRepository.findAll();
	}		
	
	// create Equipement rest api
	@PostMapping("/equipements")
	public Equipement createEquipement(@RequestBody Equipement equipement) {
		return equipementRepository.save(equipement);
	}
	
	// get Equipement by id rest api
	@GetMapping("/equipements/{id}")
	public ResponseEntity<Equipement> getEquipementById(@PathVariable Long id) {
		Equipement equipement = equipementRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Equipement not exist with id :" + id));
		return ResponseEntity.ok(equipement);
	}
	
	// get Equipement id by name 
	@GetMapping("/equipements/name/{nameE}")
	public Long findEquipementByName(@PathVariable String nameE) {
		return equipementRepository.getIdByName(nameE);
	}
	// update Equipement 
	
		@PutMapping("/equipements/{id}")
		public ResponseEntity<Equipement> updateEquipement(@PathVariable Long id, @RequestBody Equipement equipementDetails){
			Equipement equipement = equipementRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Equipement not exist with id :" + id));
			
			equipement.setName(equipementDetails.getName());
			equipement.setType(equipementDetails.getType());
			equipement.setDateService(equipement.getDateService());
			equipement.setQteWatts(equipement.getQteWatts());
			equipement.setEtatOnOff(equipement.getEtatOnOff());
			
			Equipement updatedEquipement = equipementRepository.save(equipement);
			return ResponseEntity.ok(updatedEquipement);
		}
	// delete Equipement
	@DeleteMapping("/equipements/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEquipement(@PathVariable Long id){
		Equipement equipement = equipementRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Equipement not exist with id :" + id));
		
		equipementRepository.delete(equipement);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
