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

import com.ensa.dao.EquipeDao;
import com.ensa.entity.Equipe;

public class EquipeDaoImpl implements EquipeDao {

	private Session currentSession;
	private Transaction currentTransaction;

	public EquipeDaoImpl() {
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

	public void persist(Equipe entity) {

		getCurrentSession().save(entity);

	}

	public void update(Equipe entity) {

		getCurrentSession().update(entity);

	}

	public Equipe findById(int id) {
		Session session = HibernateUtil.getFactory().openSession();
		session.beginTransaction();
		Equipe equipe = (Equipe) session.get(Equipe.class, id);
		session.getTransaction().commit();
		session.close();
		return equipe;

	}

	public void delete(Equipe entity) {

		getCurrentSession().delete(entity);

	}

	@SuppressWarnings("unchecked") // pour ne pas voir le message d'erreur uncheked cast from list to list<Equipe>

	public List<Equipe> findAll() {

		Session session = HibernateUtil.getFactory().openSession();
		session.beginTransaction();
		List<Equipe> equipes = (List<Equipe>) session.createQuery("from Equipe").list();
		session.getTransaction().commit();
		session.close();
		return equipes;

	}

	public void deleteAll() {

		List<Equipe> entityList = findAll();

		for (Equipe entity : entityList) {

			delete(entity);

		}

	}

}
