package com.spring.travauxBackendTry2.entities;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(	name = "users", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email") 
		})
public class Utilisateur implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private Integer numTel;
	private String role;
	private String villeProfession;
	private Boolean active;
	@NotBlank
	@Size(max = 20)
	private String username;
	@NotBlank
	@Size(max = 50)
	@Email
	private String email;
	@NotBlank
	@Size(max = 120)
	private String password;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	@ManyToMany
	@JsonIgnore
	private List<Travaux> travaux;
	
	public Utilisateur() {
	}

	public Utilisateur(String nom, String prenom, Integer numTel, String villeProfession, Boolean active,
			String username, String email,String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.numTel = numTel;
		this.villeProfession = villeProfession;
		this.active = active;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public Utilisateur(Long id, String nom, String prenom, Integer numTel, String villeProfession, Boolean active,
			String username, String email, String password, Set<Role> roles) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.numTel = numTel;
		this.villeProfession = villeProfession;
		this.active = active;
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public Utilisateur(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
	


	public Utilisateur(Long id, String nom, String prenom, Integer numTel, String villeProfession,
			Boolean active, String username, String email, String password) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.numTel = numTel;
		this.villeProfession = villeProfession;
		this.active = active;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Integer getNumTel() {
		return numTel;
	}

	public void setNumTel(Integer numTel) {
		this.numTel = numTel;
	}

	public String getVilleProfession() {
		return villeProfession;
	}

	public void setVilleProfession(String villeProfession) {
		this.villeProfession = villeProfession;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public List<Travaux> getTravaux() {
		return travaux;
	}

	public void setTravaux(List<Travaux> travaux) {
		this.travaux = travaux;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", numTel=" + numTel 
				+ ", villeProfession=" + villeProfession + ", active=" + active + ", username=" + username + ", email="
				+ email + ", password=" + password + ", roles=" + roles + "]";
	}
	
}