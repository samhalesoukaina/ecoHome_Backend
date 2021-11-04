package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.ClientRepository;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/ecoHome/")
public class ClientController {
	
	@Autowired
	ClientRepository clientRepo;
	
	// getAll Clients
		@GetMapping("/client")
		public long countClients() {
			return clientRepo.count();
		}
		
		// get client id by email 
		@GetMapping("/client/email/{emailId}")
		public Long findClientByEmail(@PathVariable String emailId) {
			return clientRepo.getIdClientByEmail(emailId);
		}
		

}
