package com.ensa.dao.impl;

import java.sql.Date;
import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.ensa.dao.TachesDao;
import com.ensa.entity.Employe;
import com.ensa.entity.Projet;
import com.ensa.entity.Taches;

public class TachesDaoImpl implements TachesDao {

	private static Session currentSession;
	private Transaction currentTransaction;

	public TachesDaoImpl() {
	}

	public Session openCurrentSession() {

		currentSession = getSessionFactory().openSession();

		return currentSession;

	}

	public Session openCurrentSessionwithTransaction() {

		currentSession = getSessionFactory().openSession();

		currentTransaction = (Transaction) currentSession.beginTransaction();

		return currentSession;

	}

	public void closeCurrentSession() {

		currentSession.close();

	}

	public void closeCurrentSessionwithTransaction() throws SecurityException, RollbackException,
			HeuristicMixedException, HeuristicRollbackException, SystemException {

		currentTransaction.commit();

		currentSession.close();

	}

	private static SessionFactory getSessionFactory() {

		Configuration configuration = new Configuration().configure();

		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()

				.applySettings(configuration.getProperties());

		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());

		return sessionFactory;

	}

	public Session getCurrentSession() {

		return currentSession;

	}

	public void setCurrentSession(Session currentSession) {

		this.currentSession = currentSession;

	}

	public Transaction getCurrentTransaction() {

		return currentTransaction;

	}

	public void setCurrentTransaction(Transaction currentTransaction) {

		this.currentTransaction = currentTransaction;

	}

	public void persist(Taches entity) {

		getCurrentSession().save(entity);

	}

	public void update(Taches entity) {

		getCurrentSession().update(entity);

	}
/*
	public Taches findById(int id) {
		Session session = HibernateUtil.getFactory().getCurrentSession();
		session.beginTransaction();
		Taches tache = (Taches) session.get(Taches.class, id);
		session.getTransaction().commit();
		session.close();
		return tache;

	}
*/
	public void delete(Taches entity) {

		Session session = HibernateUtil.getFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(entity);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked") // pour ne pas voir le message d'erreur uncheked cast from list to list<Taches>

	public List<Taches> findAll() {

		List<Taches> mesTaches = (List<Taches>) getCurrentSession().createQuery("from Taches").list();

		return mesTaches;

	}

	public void deleteAll() {

		List<Taches> entityList = findAll();

		for (Taches entity : entityList) {

			delete(entity);

		}

	}

	public List<Taches> findAllTachesByIdProject(String id) {

		Session session = HibernateUtil.getFactory().getCurrentSession();
		session.beginTransaction();

		// @SuppressWarnings("unchecked")
		List<Taches> list = (List<Taches>) session.createQuery("from Taches where code_pro=:id").setParameter("id", id)
				.list();

		session.getTransaction().commit();
		session.close();

		return list;

	}

	@Override
	public void addTache(int charge, Date dated, Date datef, String desc, int prio, String status, Employe e,
			Projet p) {
		Session session = HibernateUtil.getFactory().getCurrentSession();
		session.beginTransaction();
		
		
		Taches t = new Taches(desc,charge,prio,status,dated,datef,e,p);
		session.save(t);
		
		session.getTransaction().commit();
		session.close();
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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

	
	
	
	
	
}
