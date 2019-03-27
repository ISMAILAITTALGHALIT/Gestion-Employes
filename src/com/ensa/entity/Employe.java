package com.ensa.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
//import javax.persistence.Entity;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Employe")
public class Employe {
@Id
@Column(name="id_empl")
private int id_empl;

@Column(name="nom_empl", length=45)
private String nom_empl;

@Column(name="prenom_empl", length=45)
private String prenom_empl;

@Column(name="role_empl", length=45)
private String role_empl;

@Column(name="mot_passe_empl", length=45)
private String mot_passe_empl;
	
@Column(name="email_empl", length=100)
private String email_empl;

@Column(name="date_naissance_empl")
private Date date_naissance_empl;


@ManyToOne
@JoinColumn(name="code_equipe")
private Equipe equipe;

@OneToMany(mappedBy="employe")
Set<Projet> projets = new HashSet<>();

@OneToMany(mappedBy="employe")
Set<Taches> tachess = new HashSet<>();


public Equipe getEquipe() {
	return equipe;
}

public void setEquipe(Equipe equipe) {
	this.equipe = equipe;
}

public Employe() {
	super();
	// TODO Auto-generated constructor stub
}

public Employe(int id_empl, String nom_empl, String prenom_empl, String role_empl, String mot_passe_empl,
		String email_empl, Date date_naissance_empl) {
	super();
	this.id_empl = id_empl;
	this.nom_empl = nom_empl;
	this.prenom_empl = prenom_empl;
	this.role_empl = role_empl;
	this.mot_passe_empl = mot_passe_empl;
	this.email_empl = email_empl;
	this.date_naissance_empl = date_naissance_empl;
}
public Employe(int id_empl, String nom_empl, String prenom_empl, String role_empl,String email_empl, String mot_passe_empl,
		 Date date_naissance_empl,Equipe e) {
	super();
	this.id_empl = id_empl;
	this.nom_empl = nom_empl;
	this.prenom_empl = prenom_empl;
	this.role_empl = role_empl;
	this.mot_passe_empl = mot_passe_empl;
	this.email_empl = email_empl;
	this.date_naissance_empl = date_naissance_empl;
	this.equipe = e;
}

public int getId_empl() {
	return id_empl;
}

public void setId_empl(int id_empl) {
	this.id_empl = id_empl;
}

public String getNom_empl() {
	return nom_empl;
}

public void setNom_empl(String nom_empl) {
	this.nom_empl = nom_empl;
}

public String getPrenom_empl() {
	return prenom_empl;
}

public void setPrenom_empl(String prenom_empl) {
	this.prenom_empl = prenom_empl;
}

public String getRole_empl() {
	return role_empl;
}

public void setRole_empl(String role_empl) {
	this.role_empl = role_empl;
}

public String getMot_passe_empl() {
	return mot_passe_empl;
}

public void setMot_passe_empl(String mot_passe_empl) {
	this.mot_passe_empl = mot_passe_empl;
}

public String getEmail_empl() {
	return email_empl;
}

public void setEmail_empl(String email_empl) {
	this.email_empl = email_empl;
}

public Date getDate_naissance_empl() {
	return date_naissance_empl;
}

public void setDate_naissance_empl(Date date_naissance_empl) {
	this.date_naissance_empl = date_naissance_empl;
}

public Set<Projet> getProjets() {
	return projets;
}

public void setProjets(Set<Projet> projets) {
	this.projets = projets;
}

public Set<Taches> getTachess() {
	return tachess;
}

public void setTachess(Set<Taches> tachess) {
	this.tachess = tachess;
}




}
