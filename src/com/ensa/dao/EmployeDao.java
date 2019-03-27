package com.ensa.dao;

import java.sql.Date;
import java.util.List;



import com.ensa.entity.Employe;


public interface EmployeDao {
	
	
	//void persist(Employe entity);
	//void update(Employe entity);
	Employe findById(int id);
	void delete(Employe entity);
	static List<Employe> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	void addEmplye(int id,String name,String pren,String role,String email,String pass,Date daten,int code);
	void deleteAll();
	int findByLoginMdp(String email,String password);
	String findRole(String nom);
	Employe findByEmail(String email);
	List<Employe> getEmployes();
	void updateEmpl(int id, String nom, String prenom, String role, String email, Date date);
	
}
