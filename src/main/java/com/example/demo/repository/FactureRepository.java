package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Facture;



public interface FactureRepository extends JpaRepository<Facture, Long>{
	
	/*@Query( value = "select c.*, employees.first_name as employee_first_name, employees.last_name as employee_last_name from conges c left join employees on employees.id = c.employee", nativeQuery = true)
	public List<Facture> findAllConges();
	
	//find conges by employee id
		@Query( value = "select * from conges  where employee = ?1", nativeQuery = true)
		public List<Facture> findCongebyEmployeId(Integer employee);*/

}
