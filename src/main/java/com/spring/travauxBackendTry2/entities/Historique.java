package com.spring.travauxBackendTry2.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="historique")
public class Historique {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_historique")
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date dateOperation;
	private String operation;
	
	private String etatOperation;
	
	//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@Column(name = "id_technicien")
	private Integer technicien;
	@Column(name = "id_admin")
	private Integer admin;
	
	
	@ManyToOne
	@JsonIgnore
	private Travaux travaux;
	
	public Historique() {
		super();
	}

	public Historique(Long id, Date dateOperation, String operation) {
		super();
		this.id = id;
		this.dateOperation = dateOperation;
		this.operation = operation;
	}

	public Historique(Long id, Date dateOperation, String operation, Travaux travaux) {
		super();
		this.id = id;
		this.dateOperation = dateOperation;
		this.operation = operation;
		this.travaux = travaux;
	}

	public Historique(Long id, Date dateOperation, String operation, Integer technicien, Integer admin,Travaux travaux) {
		super();
		this.id = id;
		this.dateOperation = dateOperation;
		this.operation = operation;
		this.technicien = technicien;
		this.admin = admin;
		this.travaux = travaux;
	}

	public Historique(Date dateOperation, String operation, String etatOperation) {
		super();
		this.dateOperation = dateOperation;
		this.operation = operation;
		this.etatOperation = etatOperation;
	}

	public Historique(Date dateOperation, String operation, String etatOperation, Integer technicien, Integer admin) {
		super();
		this.dateOperation = dateOperation;
		this.operation = operation;
		this.etatOperation = etatOperation;
		this.technicien = technicien;
		this.admin = admin;
	}

	public Historique(Date dateOperation, String operation, String etatOperation, Integer technicien, Integer admin,
			Travaux travaux) {
		super();
		this.dateOperation = dateOperation;
		this.operation = operation;
		this.etatOperation = etatOperation;
		this.technicien = technicien;
		this.admin = admin;
		this.travaux = travaux;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	

	public Integer getTechnicien() {
		return technicien;
	}

	public void setTechnicien(Integer technicien) {
		this.technicien = technicien;
	}

	public Integer getAdmin() {
		return admin;
	}

	public void setAdmin(Integer admin) {
		this.admin = admin;
	}

	public Travaux getTravaux() {
		return travaux;
	}

	public void setTravaux(Travaux travaux) {
		this.travaux = travaux;
	}

	public String getEtatOperation() {
		return etatOperation;
	}

	public void setEtatOperation(String etatOperation) {
		this.etatOperation = etatOperation;
	}

	@Override
	public String toString() {
		return "Historique [id=" + id + ", dateOperation=" + dateOperation + ", operation=" + operation + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateOperation, id, operation);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Historique other = (Historique) obj;
		return Objects.equals(dateOperation, other.dateOperation) && Objects.equals(id, other.id)
				&& Objects.equals(operation, other.operation);
	}
	
}