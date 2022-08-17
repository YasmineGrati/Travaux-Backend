package com.spring.travauxBackendTry2.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="travaux")
public class Travaux {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_travaux")
	private Long id;
	private String etatAffectation;
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private Date dateSaisie;
	
	@Temporal(TemporalType.DATE)
	private Date datePlanification;
	@Column(unique = true)
	private Integer msisdn;
	@Column(unique = true)
	private Integer numClient;
	
	@OneToOne
	private Adresse adresse;
	
	@OneToMany(mappedBy="travaux", cascade=CascadeType.ALL)
	@JsonIgnore
    private List<Historique> historiques;
	
	
	 @ManyToMany(mappedBy="travaux", cascade = CascadeType.ALL)
	 private List<Utilisateur> techniciens;
	
	public Travaux() {
		super();
	}

	public Travaux(String etatAffectation, Date dateSaisie, Date datePlanification, Integer msisdn, Integer numClient,
			Adresse adresse) {
		super();
		this.etatAffectation = etatAffectation;
		this.dateSaisie = dateSaisie;
		this.datePlanification = datePlanification;
		this.msisdn = msisdn;
		this.numClient = numClient;
		this.adresse = adresse;
	}

	public Travaux(Long id, String etatAffectation, Date dateSaisie) {
		super();
		this.id = id;
		this.etatAffectation = etatAffectation;
		this.dateSaisie = dateSaisie;
	}

	public Travaux(Long id, String etatAffectation, Date dateSaisie, Adresse adresse) {
		super();
		this.id = id;
		this.etatAffectation = etatAffectation;
		this.dateSaisie = dateSaisie;
		this.adresse = adresse;
	}

	public Travaux(Long id, String etatAffectation, Date dateSaisie, Adresse adresse, List<Historique> historiques, List<Utilisateur> techniciens) {
		super();
		this.id = id;
		this.etatAffectation = etatAffectation;
		this.dateSaisie = dateSaisie;
		this.adresse = adresse;
		this.historiques = historiques;
		this.techniciens = techniciens;
	}
	
	public Travaux(Long id, String etatAffectation, Date dateSaisie, Date datePlanification, Integer msisdn,
			Integer numClient) {
		super();
		this.id = id;
		this.etatAffectation = etatAffectation;
		this.dateSaisie = dateSaisie;
		this.datePlanification = datePlanification;
		this.msisdn = msisdn;
		this.numClient = numClient;
	}

	public Travaux(Long id, String etatAffectation, Date dateSaisie, Date datePlanification, Integer msisdn,
			Integer numClient, Adresse adresse) {
		super();
		this.id = id;
		this.etatAffectation = etatAffectation;
		this.dateSaisie = dateSaisie;
		this.datePlanification = datePlanification;
		this.msisdn = msisdn;
		this.numClient = numClient;
		this.adresse = adresse;
	}

	public Travaux(Long id, String etatAffectation, Date dateSaisie, Date datePlanification, Integer msisdn,
			Integer numClient, Adresse adresse, List<Historique> historiques, List<Utilisateur> techniciens) {
		super();
		this.id = id;
		this.etatAffectation = etatAffectation;
		this.dateSaisie = dateSaisie;
		this.datePlanification = datePlanification;
		this.msisdn = msisdn;
		this.numClient = numClient;
		this.adresse = adresse;
		this.historiques = historiques;
		this.techniciens = techniciens;
	}

	public Travaux(Long id, String etatAffectation, Date dateSaisie, Date datePlanification, Integer msisdn,
			Integer numClient, Adresse adresse, List<Historique> historiques) {
		super();
		this.id = id;
		this.etatAffectation = etatAffectation;
		this.dateSaisie = dateSaisie;
		this.datePlanification = datePlanification;
		this.msisdn = msisdn;
		this.numClient = numClient;
		this.adresse = adresse;
		this.historiques = historiques;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEtatAffectation() {
		return etatAffectation;
	}

	public void setEtatAffectation(String etatAffectation) {
		this.etatAffectation = etatAffectation;
	}

	public Date getDateSaisie() {
		return dateSaisie;
	}

	public void setDateSaisie(Date dateSaisie) {
		this.dateSaisie = dateSaisie;
	}
	

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Historique> getHistoriques() {
		return historiques;
	}

	public void setHistoriques(List<Historique> historiques) {
		this.historiques = historiques;
	}

	public List<Utilisateur> getTechniciens() {
		return techniciens;
	}

	public void setTechniciens(List<Utilisateur> techniciens) {
		this.techniciens = techniciens;
	}

	public Date getDatePlanification() {
		return datePlanification;
	}

	public void setDatePlanification(Date datePlanification) {
		this.datePlanification = datePlanification;
	}

	public Integer getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(Integer msisdn) {
		this.msisdn = msisdn;
	}

	public Integer getNumClient() {
		return numClient;
	}

	public void setNumClient(Integer numClient) {
		this.numClient = numClient;
	}

	@Override
	public String toString() {
		return "Travaux [id=" + id + ", etatAffectation=" + etatAffectation + ", dateSaisie=" + dateSaisie
				+ ", adresse=" + adresse + ", historiques=" + historiques + ", techniciens=" + techniciens + "]";
	}

}