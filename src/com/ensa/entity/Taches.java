package com.ensa.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="Taches")
public class Taches {

	
@Id

@Column(name="id_tache")
private int id_tache;

@Column(name="description_tache", length=45)
private String description_tache;

@Column(name="charge_horaire_tache")
private int charge_horaire_tache;

@Column(name="priorite_tache")
private int priorite_tache;

@Column(name="statut_tache", length=10)
private String statut_tache;

@Column(name="date_debut_tache")
private Date date_debut_tache;

@Column(name="date_fin_tache")
private Date date_fin_tache;



@ManyToOne
@JoinColumn(name="id_empl")
private Employe employe;


@ManyToOne
@JoinColumn(name="code_pro")

private Projet projet;

public Taches() {
	super();
	// TODO Auto-generated constructor stub
}

public Taches(int id_tache, String description_tache, int charge_horaire_tache, int priorite_tache, String statut_tache,
		Date date_debut_tache, Date date_fin_tache) {
	super();
	this.id_tache = id_tache;
	this.description_tache = description_tache;
	this.charge_horaire_tache = charge_horaire_tache;
	this.priorite_tache = priorite_tache;
	this.statut_tache = statut_tache;
	this.date_debut_tache = date_debut_tache;
	this.date_fin_tache = date_fin_tache;
}
public Taches( String description_tache, int charge_horaire_tache, int priorite_tache, String statut_tache,
		Date date_debut_tache, Date date_fin_tache,Employe e,Projet p) {
	super();
	this.id_tache = id_tache;
	this.description_tache = description_tache;
	this.charge_horaire_tache = charge_horaire_tache;
	this.priorite_tache = priorite_tache;
	this.statut_tache = statut_tache;
	this.date_debut_tache = date_debut_tache;
	this.date_fin_tache = date_fin_tache;
	this.employe = e;
	this.projet = p;
}

public int getId_tache() {
	return id_tache;
}

public void setId_tache(int id_tache) {
	this.id_tache = id_tache;
}

public String getDescription_tache() {
	return description_tache;
}

public void setDescription_tache(String description_tache) {
	this.description_tache = description_tache;
}

public int getCharge_horaire_tache() {
	return charge_horaire_tache;
}

public void setCharge_horaire_tache(int charge_horaire_tache) {
	this.charge_horaire_tache = charge_horaire_tache;
}

public int getPriorite_tache() {
	return priorite_tache;
}

public void setPriorite_tache(int priorite_tache) {
	this.priorite_tache = priorite_tache;
}

public String getStatut_tache() {
	return statut_tache;
}

public void setStatut_tache(String statut_tache) {
	this.statut_tache = statut_tache;
}

public Date getDate_debut_tache() {
	return date_debut_tache;
}

public void setDate_debut_tache(Date date_debut_tache) {
	this.date_debut_tache = date_debut_tache;
}

public Date getDate_fin_tache() {
	return date_fin_tache;
}

public void setDate_fin_tache(Date date_fin_tache) {
	this.date_fin_tache = date_fin_tache;
}

public Employe getEmplye() {
	return employe;
}

public void setEmplye(Employe emplye) {
	this.employe = emplye;
}

public Employe getEmploye() {
	return employe;
}

public void setEmploye(Employe employe) {
	this.employe = employe;
}

public Projet getProjet() {
	return projet;
}

public void setProjet(Projet projet) {
	this.projet = projet;
}



}
