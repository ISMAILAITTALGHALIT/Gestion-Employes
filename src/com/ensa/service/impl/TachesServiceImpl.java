package com.ensa.service.impl;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ensa.dao.impl.HibernateUtil;
import com.ensa.dao.impl.TachesDaoImpl;
import com.ensa.entity.Employe;
import com.ensa.entity.Taches;
import com.ensa.service.TachesService;

public class TachesServiceImpl implements TachesService {
/*
	public List<Taches> findTachesByEmploye(Employe emp) {

		TachesDaoImpl tachesDaoImpl = new TachesDaoImpl();
		SessionFactory factory = HibernateUtil.getFactory();
		Session s = factory.getCurrentSession();
		s.beginTransaction();

		List<Taches> taches = (List<Taches>) s.createQuery("from Taches where id_empl =:id")
				.setParameter("id", emp.getId_empl()).list();

		s.getTransaction().commit();
		s.close();

		return taches;
	}

	@Override
	public Taches findById(int id) {
		TachesDaoImpl tachesDaoImpl = new TachesDaoImpl();
		SessionFactory factory = HibernateUtil.getFactory();
		Session s = factory.getCurrentSession();
		s.beginTransaction();

		Taches taches = (Taches) s.createQuery("from Taches where id_tache =:id").setParameter("id", id)
				.getSingleResult();

		s.getTransaction().commit();
		s.close();

		return taches;
	}

	@Override
	public void updateTache(int id, Date debut, Date fin, String status) {
		// TODO Auto-generated method stub
		TachesDaoImpl tachesDaoImpl = new TachesDaoImpl();
		SessionFactory factory = HibernateUtil.getFactory();
		Session s = factory.getCurrentSession();
		s.beginTransaction();

		Taches t = s.get(Taches.class, id);
		t.setDate_debut_tache(debut);
		t.setDate_fin_tache(fin);
		t.setStatut_tache(status);

		s.save(t);
		
		s.getTransaction().commit();
		s.close();

	}

	@Override
	public void updateTache(int id, Date debut, Date fin, String status, String desc, int chargeH, int prio,
			Employe emp) {

		TachesDaoImpl tachesDaoImpl = new TachesDaoImpl();
		SessionFactory factory = HibernateUtil.getFactory();
		Session s = factory.getCurrentSession();
		s.beginTransaction();

		Taches t = s.get(Taches.class,id);
		t.setDate_debut_tache(debut);
		t.setDate_fin_tache(fin);
		t.setStatut_tache(status);
		t.setCharge_horaire_tache(chargeH);
		t.setDescription_tache(desc);
		t.setEmploye(emp);
		t.setPriorite_tache(prio);
		
		s.save(t);
		
		s.getTransaction().commit();
		s.close();
		
	}
*/
}
