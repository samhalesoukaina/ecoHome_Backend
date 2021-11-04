package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Client;


public interface ClientRepository extends JpaRepository<Client, Long>{
	@Query( value = "select id from client  where email_id = ?1", nativeQuery = true)
	public Long getIdClientByEmail(String email);

}
