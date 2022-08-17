package com.spring.travauxBackendTry2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="adresse")
public class Adresse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_adresse")
	private Long id;
	
	private String adresse;
	private String ville;
	private String localite;
	private String delegation;
	private String latitude;
	private String longitude;
	
	@OneToOne(mappedBy = "adresse")
	@JsonIgnore
    private Travaux travaux;
	
	public Adresse() {
		super();
	}
	public Adresse(Long id, String adresse, String ville, String localite, String delegation) {
		super();
		this.id = id;
		this.adresse = adresse;
		this.ville = ville;
		this.localite = localite;
		this.delegation = delegation;
	}
	
	public Adresse(Long id, String adresse, String ville, String localite, String delegation, String latitude,
			String longitude, Travaux travaux) {
		super();
		this.id = id;
		this.adresse = adresse;
		this.ville = ville;
		this.localite = localite;
		this.delegation = delegation;
		this.latitude = latitude;
		this.longitude = longitude;
		this.travaux = travaux;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getLocalite() {
		return localite;
	}
	public void setLocalite(String localite) {
		this.localite = localite;
	}
	public String getDelegation() {
		return delegation;
	}
	public void setDelegation(String delegation) {
		this.delegation = delegation;
	}
	
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public Travaux getTravaux() {
		return travaux;
	}
	public void setTravaux(Travaux travaux) {
		this.travaux = travaux;
	}
	@Override
	public String toString() {
		return "Adresse [id=" + id + ", adresse=" + adresse + ", ville=" + ville + ", localite=" + localite
				+ ", delegation=" + delegation + "]";
	}

}