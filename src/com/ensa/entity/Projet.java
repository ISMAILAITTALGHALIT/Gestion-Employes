package com.ensa.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Projet")
public class Projet {
	
@Id	
@Column(name="code_pro", length=6)
private String code_pro;

@Column(name="nom_pro", length=45)
private String nom_pro;
	
@Column(name="description_pro", length=255)
private String description_pro;

@Column(name="charge_horaire_pro")
private int charge_horaire_pro;

@OneToMany(mappedBy="projet")

Set<Taches> tachess= new HashSet<>();


@ManyToOne
@JoinColumn(name="id_chef_projet")

private Employe employe;

public Projet() {
	super();
	// TODO Auto-generated constructor stub
}

public Projet(String code_pro, String nom_pro, String description_pro, int charge_horaire_pro) {
	super();
	this.code_pro = code_pro;
	this.nom_pro = nom_pro;
	this.description_pro = description_pro;
	this.charge_horaire_pro = charge_horaire_pro;
}

public String getCode_pro() {
	return code_pro;
}

public void setCode_pro(String code_pro) {
	this.code_pro = code_pro;
}

public String getNom_pro() {
	return nom_pro;
}

public void setNom_pro(String nom_pro) {
	this.nom_pro = nom_pro;
}

public String getDescription_pro() {
	return description_pro;
}

public void setDescription_pro(String description_pro) {
	this.description_pro = description_pro;
}

public int getCharge_horaire_pro() {
	return charge_horaire_pro;
}

public void setCharge_horaire_pro(int charge_horaire_pro) {
	this.charge_horaire_pro = charge_horaire_pro;
}

public Set<Taches> getTachess() {
	return tachess;
}

public void setTachess(Set<Taches> tachess) {
	this.tachess = tachess;
}

public Employe getEmploye() {
	return employe;
}

public void setEmploye(Employe employe) {
	this.employe = employe;
}


	
	
	
}
