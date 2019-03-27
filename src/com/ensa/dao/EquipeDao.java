package com.ensa.dao;

import java.util.List;

import com.ensa.entity.Equipe;


public interface EquipeDao {

	void persist(Equipe entity);
	void update(Equipe entity);
	Equipe findById(int id);
	void delete(Equipe entity);
	List<Equipe> findAll();
	void deleteAll();
	
}
