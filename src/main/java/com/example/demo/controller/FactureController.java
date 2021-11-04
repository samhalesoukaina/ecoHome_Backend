package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Facture;
import com.example.demo.repository.FactureRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/ecoHome/")
public class FactureController {
	
	@Autowired
	FactureRepository factureRepo;
	
	//tous les taches cree
		/*@RequestMapping("/facture")
		public List<Facture> getAllCreatedFactures()
		{
			List<Facture> factures=new ArrayList<>();
			factureRepo.findAllFactures().forEach(factures::add);
			return fFactures;
		}*/
		
		//trouver tache par id 
		@GetMapping("/facture/{id}")
		public ResponseEntity<Facture> getFactureById(@PathVariable Long id) {
			Facture facture = factureRepo.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Facture not exist with id :" + id));
			return ResponseEntity.ok(facture);
		}
		
		//trouver les taches d'un employee
		/*@RequestMapping("/equipement/{id}/conge")
		public List<Facture> getAllConges(@PathVariable Integer id)
		{
			List<Facture> conges=new ArrayList<>();
			factureRepo.findCongebyEmployeId(id).forEach(conges::add);
			return conges;
		}*/
		
		/*@PostMapping("/equipement/{equimepentId}/facture")
		public Facture createFacture(@RequestBody Facture facture , @PathVariable Integer equipementId) {
			Facture.setEmployee(new Employee(employeId));
			return factureRepo.save(conge);
		}*/
		
		//modifier la decision  pour la demande de conge
		/*
		@PutMapping("/conges/{decision}/{id}")
		public ResponseEntity<Facture> updateCongeDecision(@PathVariable String decision, @PathVariable Long id){
			Facture conge = congeRepo.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("conge not exist with id :" + id));
			conge.setEtatDemande(decision);
			Facture updatedConge = congeRepo.save(conge);
			return ResponseEntity.ok(updatedConge);
			
		}*/
		
		/*delete tache
		// delete employee rest api
			@DeleteMapping("/conges/{id}")
			public ResponseEntity<Map<String, Boolean>> deleteConge(@PathVariable Long id){
				Conge conge = congeRepo.findById(id)
						.orElseThrow(() -> new ResourceNotFoundException("conge not exist with id :" + id));
				
				congeRepo.delete(conge);
				Map<String, Boolean> response = new HashMap<>();
				response.put("deleted", Boolean.TRUE);
				return ResponseEntity.ok(response);
			}
	*/
	

}
