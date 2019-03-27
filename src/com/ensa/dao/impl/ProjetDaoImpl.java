package com.ensa.dao.impl;

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

import com.ensa.dao.ProjetDao;
import com.ensa.entity.Projet;
import com.ensa.entity.Taches;

public class ProjetDaoImpl implements ProjetDao {

	private Session currentSession;
	private Transaction currentTransaction;

	public ProjetDaoImpl() {
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

	public void persist(Projet entity) {

		getCurrentSession().save(entity);

	}

	public void update(Projet entity) {

		getCurrentSession().update(entity);

	}

	public Projet findById(String id) {
		Session s =  HibernateUtil.getFactory().openSession();
		s.beginTransaction();

		Projet projet = (Projet) s.get(Projet.class, id);
		s.getTransaction().commit();
		s.close();
		return projet;

	}

	public void delete(Projet entity) {

		Session session = HibernateUtil.getFactory().getCurrentSession();
		session.beginTransaction();

		session.delete(entity);

		session.getTransaction().commit();
		session.close();

	}

	@SuppressWarnings("unchecked") // pour ne pas voir le message d'erreur uncheked cast from list to list<Projet>

	public List<Projet> findAll() {

		List<Projet> projets = (List<Projet>) getCurrentSession().createQuery("from Projet").list();

		return projets;

	}

	public void deleteAll() {

		List<Projet> entityList = findAll();

		for (Projet entity : entityList) {

			delete(entity);

		}

	}

	public List<Projet> findProjetByEmpId(int id) {

		Session session = HibernateUtil.getFactory().getCurrentSession();
		session.beginTransaction();

		List<Projet> list = (List<Projet>) session.createQuery("from Projet where id_chef_projet=:id")
				.setParameter("id", id).list();

		session.getTransaction().commit();
		session.close();

		return list;

	}

	public void updateProjet(String code, String nom, String description, int charge) {
		ProjetDaoImpl pro = new ProjetDaoImpl();
		Session s = HibernateUtil.getFactory().getCurrentSession();
		s.beginTransaction();

		Projet p = s.get(Projet.class, code);

		p.setCode_pro(code);
		p.setNom_pro(nom);
		p.setDescription_pro(description);
		p.setCharge_horaire_pro(charge);

		s.save(p);

		s.getTransaction().commit();
		s.close();

	}

	@Override
	public void addProjet(String code, int charge, String desc, String nom, int id) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getFactory().openSession();
		s.beginTransaction();

		Projet p = new Projet(code, nom, desc, charge);
		EmployeDaoImpl e = new EmployeDaoImpl();

		p.setEmploye(e.findById(id));

		s.save(p);

		s.getTransaction().commit();
		s.close();
	}

}
