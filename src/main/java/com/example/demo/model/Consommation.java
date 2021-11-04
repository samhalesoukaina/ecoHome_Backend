package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "consommation")
public class Consommation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "jour")
	private int jour;
	
	@Column(name = "mois")
	private int mois;
	
	@Column(name = "heure")
	private int heure;
	
	@Column(name = "qteWattsHeure")
	private float qteWattsHeure;
	
	@Column(name = "qteWattsJour")
	private float qteWattsJour;
	
	@Column(name = "qteWattsMois")
	private float qteWattsMois;
	
	@ManyToOne
	@JoinColumn(name = "equipement")
	private Equipement equipement;
	
	@ManyToOne
	@JoinColumn(name = "facture")
	private Facture facture;
	

	public Consommation ()
	{
		
	}


	public Consommation(int jour, int mois, int heure, float qteWattsHeure, float qteWattsJour, float qteWattsMois,
			Equipement equipement) {
		super();
		this.jour = jour;
		this.mois = mois;
		this.heure = heure;
		this.qteWattsHeure = qteWattsHeure;
		this.qteWattsJour = qteWattsJour;
		this.qteWattsMois = qteWattsMois;
		this.equipement = equipement;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public int getJour() {
		return jour;
	}


	public void setJour(int jour) {
		this.jour = jour;
	}


	public int getMois() {
		return mois;
	}


	public void setMois(int mois) {
		this.mois = mois;
	}


	public int getHeure() {
		return heure;
	}


	public void setHeure(int heure) {
		this.heure = heure;
	}


	public float getQteWattsHeure() {
		return qteWattsHeure;
	}


	public void setQteWattsHeure(float qteWattsHeure) {
		this.qteWattsHeure = qteWattsHeure;
	}


	public float getQteWattsJour() {
		return qteWattsJour;
	}


	public void setQteWattsJour(float qteWattsJour) {
		this.qteWattsJour = qteWattsJour;
	}


	public float getQteWattsMois() {
		return qteWattsMois;
	}


	public void setQteWattsMois(float qteWattsMois) {
		this.qteWattsMois = qteWattsMois;
	}


	public Equipement getEquipement() {
		return equipement;
	}


	public void setEquipement(Equipement equipement) {
		this.equipement = equipement;
	}


	public Facture getFacture() {
		return facture;
	}


	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	
	
	
	
	
	

	
	
	
	
	

}
