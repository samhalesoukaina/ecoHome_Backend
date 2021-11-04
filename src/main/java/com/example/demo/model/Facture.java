package com.example.demo.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "facture")
public class Facture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "date_debut")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_debut;
	
	@Column(name = "date_fin")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_fin;
	
	@Column(name = "prixKwattsheure")
	private float prixKwattsheure;
	
	@Column(name = "montantTotal")
	private int montantTotal;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="facture")
	@JsonIgnore
  	private List<Consommation> consommations;
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}
	
	public Facture() {
		
	}


	public Facture(LocalDate date_debut, LocalDate date_fin, float prixKwattsheure, int montantTotal,
			List<Consommation> consommations) {
		super();
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.prixKwattsheure = prixKwattsheure;
		this.montantTotal = montantTotal;
		this.consommations = consommations;
	}


	public LocalDate getDate_debut() {
		return date_debut;
	}


	public void setDate_debut(LocalDate date_debut) {
		this.date_debut = date_debut;
	}


	public LocalDate getDate_fin() {
		return date_fin;
	}


	public void setDate_fin(LocalDate date_fin) {
		this.date_fin = date_fin;
	}


	public float getPrixKwattsheure() {
		return prixKwattsheure;
	}


	public void setPrixKwattsheure(float prixKwattsheure) {
		this.prixKwattsheure = prixKwattsheure;
	}


	public int getMontantTotal() {
		return montantTotal;
	}


	public void setMontantTotal(int montantTotal) {
		this.montantTotal = montantTotal;
	}


	public List<Consommation> getConsommations() {
		return consommations;
	}


	public void setConsommations(List<Consommation> consommations) {
		this.consommations = consommations;
	}
	
	 
	
	
	
}
