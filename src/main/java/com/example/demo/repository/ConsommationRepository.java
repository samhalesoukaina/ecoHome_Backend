package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Consommation;


public interface ConsommationRepository extends JpaRepository<Consommation, Long>{
   
	//Get consommations by equipement id
	@Query( value = "select * from consommation c where c.equipement = ?1", nativeQuery = true)
	public List<Consommation> findConsommationbyEquipementId(Integer equipementId); 
	
	//Get consommation by mois
	@Query( value = "select * from consommation c where c.mois = ?1", nativeQuery = true)
	public List<Consommation> findConsommationByMois(int mois);
	
	
	/*@Query( value = "select t.*, employees.first_name as employee_first_name, employees.last_name as employee_last_name from taches t left join employees on employees.id = t.employee", nativeQuery = true)
	public List<Consommation> findAllTaches();
	
	@Query( value = "select COUNT(*) from taches where tache_statut = \"resolu\" AND employee = ?1", nativeQuery = true)
	public int countTaches(Long empId);
	
	@Query( value = "select COUNT(*) from taches where  employee = ?1", nativeQuery = true)
	public int countTachesAffectees(Long empId);*/
}
	
