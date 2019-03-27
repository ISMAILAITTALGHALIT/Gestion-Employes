package com.ensa.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Equipe")

public class Equipe {
@Id

@Column(name="code_equipe")
private int code_equipe;

@Column(name="nom_equipe", length=45)
private String nom_equipe;

@Column(name="description_equipe", length=255)
private String description_equipe;


@OneToMany(mappedBy="equipe")
Set<Employe> employes = new HashSet<>();

public Equipe() {
	super();
	// TODO Auto-generated constructor stub
}



public Equipe(int code_equipe, String nom_equipe, String description_equipe) {
	super();
	this.code_equipe = code_equipe;
	this.nom_equipe = nom_equipe;
	this.description_equipe = description_equipe;
}



public int getCode_equipe() {
	return code_equipe;
}



public void setCode_equipe(int code_equipe) {
	this.code_equipe = code_equipe;
}



public String getNom_equipe() {
	return nom_equipe;
}



public void setNom_equipe(String nom_equipe) {
	this.nom_equipe = nom_equipe;
}



public String getDescription_equipe() {
	return description_equipe;
}



public void setDescription_equipe(String description_equipe) {
	this.description_equipe = description_equipe;
}



public Set<Employe> getEmployes() {
	return employes;
}



public void setEmployes(Set<Employe> employes) {
	this.employes = employes;
}


	
	
	
}
