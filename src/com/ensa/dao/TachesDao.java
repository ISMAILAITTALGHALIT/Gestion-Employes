package com.ensa.dao;

import java.sql.Date;
import java.util.List;

import com.ensa.entity.Employe;
import com.ensa.entity.Projet;
import com.ensa.entity.Taches;

public interface TachesDao {
	
	
	void persist(Taches entity);
	void update(Taches entity);
	Taches findById(int id);
	void delete(Taches entity);
	static List<Taches> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	void deleteAll();
	void addTache(int charge,Date dated,Date datef,String desc, int prio, String status ,Employe e,Projet p);
	List<Taches> findAllTachesByIdProject(String id);
	//List<Taches> findTachesByEmploye(Employe emp);
	
	
	
	
	List<Taches> findTachesByEmploye(Employe emp);
	void updateTache(int id, Date debut, Date fin, String status);
	void updateTache(int id, Date debut, Date fin, String status,String desc, int chargeH,int prio,Employe emp);

	
	
	
	
	
	
}
