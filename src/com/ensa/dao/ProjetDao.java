package com.ensa.dao;

import java.util.List;

import com.ensa.entity.Projet;

public interface ProjetDao {

	void persist(Projet entity);
	void update(Projet entity);
	Projet findById(String id);
	void delete(Projet entity);
	List<Projet> findAll();
	void deleteAll();
	List<Projet> findProjetByEmpId(int id);
	void updateProjet(String code,String nom,String description,int charge);
	void addProjet(String code,int charge ,String desc, String nom,int id );
	
	
}
