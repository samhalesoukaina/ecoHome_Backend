package com.example.demo.model;

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
@Table(name = "equipement")
public class Equipement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "type")
	private String type;
	
	@Column(name = "qtewatts")
	private float qteWatts;
	
	@Column(name = "etatOnOff")
	private Boolean etatOnOff;
	
	@Column(name = "dateService")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String dateService;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="equipement")
	@JsonIgnore
  	private List<Consommation> consommations;
	
	
	public Equipement() {
		
	}
	
	public Equipement(int id) {
			this.id = id ;
		}
	
	public Equipement(String name, String type, float qteWatts, Boolean etatOnOff, String dateService) {
		super();
		this.name = name;
		this.type = type;
		this.qteWatts = qteWatts;
		this.etatOnOff = etatOnOff;
		this.dateService = dateService;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getQteWatts() {
		return qteWatts;
	}

	public void setQteWatts(float qteWatts) {
		this.qteWatts = qteWatts;
	}

	public Boolean getEtatOnOff() {
		return etatOnOff;
	}

	public void setEtatOnOff(Boolean etatOnOff) {
		this.etatOnOff = etatOnOff;
	}

	public String getDateService() {
		return dateService;
	}

	public void setDateService(String dateService) {
		this.dateService = dateService;
	}
	
	
	
	
	
}

