package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Equipement;



@Repository
public interface EquipementRepository extends JpaRepository<Equipement, Long>{
	
	@Query( value = "select id from equipement  where name = ?1", nativeQuery = true)
	public Long getIdByName(String name);
}
