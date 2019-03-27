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
import org.hibernate.query.Query;

import com.ensa.dao.EmployeDao;
import com.ensa.entity.Employe;
import com.ensa.entity.Taches;

public class EmployeDaoImpl implements EmployeDao {
/*
	private Session currentSession;
	private Transaction currentTransaction;

	public EmployeDaoImpl() {
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

	public void persist(Employe entity) {

		getCurrentSession().save(entity);

	}

	public void update(Employe entity) {

		getCurrentSession().update(entity);

	}
*/
	public Employe findById(int id) {
		Session session = HibernateUtil.getFactory().getCurrentSession();
		session.beginTransaction();

		Employe employe = (Employe) session.get(Employe.class, id);
		session.getTransaction().commit();
		session.close();
		return employe;

	}

	public void delete(Employe entity) {
		Session session = HibernateUtil.getFactory().openSession();
		session.beginTransaction();
		session.delete(entity);
		session.getTransaction().commit();
		session.close();

	}

	@SuppressWarnings("unchecked") // pour ne pas voir le message d'erreur uncheked cast from list to list<Employe>

	public List<Employe> findAll() {

		Session session = HibernateUtil.getFactory().openSession();
		session.beginTransaction();
		List<Employe> employes = (List<Employe>) session.createQuery("from Employe").list();
		session.getTransaction().commit();
		session.close();
		return employes;

	}

	public void deleteAll() {

		List<Employe> entityList = findAll();

		for (Employe entity : entityList) {

			delete(entity);

		}

	}

	@Override
	public int findByLoginMdp(String email, String password) {
		int count = 0;

		try {
			@SuppressWarnings("deprecation")
			SessionFactory factory = HibernateUtil.getFactory();
			Session session = factory.openSession();
			session.beginTransaction();

			Query query = (Query) session
					.createQuery("select nom_empl from Employe where email_empl=:a and mot_passe_empl=:b ");
			query.setParameter("a", email);
			query.setParameter("b", password);

			List<String> listNoms = query.list();
			System.out.println("Nom des personnes:");

			for (String nom : listNoms) {
				System.out.println("\t" + nom);
				count++;
			}
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			System.out.println("erreur : " + e.getMessage());
		}

		return count;
	}

	public int login(String email, String pass) {
		int l = 0;

		try {
			System.out.println("bonjour");
			Session session = HibernateUtil.getFactory().getCurrentSession();
			System.out.println("bonjour");
			session.beginTransaction();
			System.out.println("bonjour");
			l = Integer.parseInt(
					session.createQuery("Select count(*) From Employe where email_empl=:email and mot_passe_empl=:pass")
							.setParameter("email", email).setParameter("pass", pass).uniqueResult().toString());
			System.out.println("bonjour");

			session.getTransaction().commit();
			session.close();

			System.out.println("le nombre d users : " + l);

		} catch (Exception e) {

			System.out.println("erreur: " + e.getMessage());
			System.err.println("Erreur: " + e);

		}
		return l;

	}

	@Override
	public String findRole(String email) {

		Session session = HibernateUtil.getFactory().getCurrentSession();
		session.beginTransaction();

		Query query = session.createQuery("SELECT emp.role_empl from Employe as emp where emp.email_empl=:n");
		query.setParameter("n", email);
		String role = (String) query.getSingleResult();
		session.getTransaction().commit();
		session.close();
		return role;
	}

	@Override
	public Employe findByEmail(String email) {

		Session session = HibernateUtil.getFactory().getCurrentSession();
		session.beginTransaction();

		Query query = session.createQuery("from Employe as emp where emp.email_empl=:n");
		query.setParameter("n", email);

		Employe employe = (Employe) query.getSingleResult();
		session.getTransaction().commit();
		session.close();
		return employe;
	}

	@Override
	public List<Employe> getEmployes() {
		// TODO Auto-generated method stub

		Session session = HibernateUtil.getFactory().getCurrentSession();
		session.beginTransaction();

		List<Employe> employes = (List<Employe>) session.createQuery("from Employe where role_empl = 'Employe'").list();

		session.getTransaction().commit();
		session.close();
		return employes;
	}

	@Override
	public void updateEmpl(int id, String nom, String prenom, String role, String email, Date date) {

		SessionFactory factory = HibernateUtil.getFactory();
		Session s = factory.getCurrentSession();
		s.beginTransaction();

		Employe e = s.get(Employe.class, id);
		e.setId_empl(id);
		e.setNom_empl(nom);
		e.setPrenom_empl(prenom);
		e.setRole_empl(role);
		e.setEmail_empl(email);
		e.setDate_naissance_empl(date);

		s.save(e);

		s.getTransaction().commit();
		s.close();

	}

	@Override
	public void addEmplye(int id, String name, String pren, String role, String email, String pass, Date daten,
			int code) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtil.getFactory();
		Session s = factory.getCurrentSession();
		s.beginTransaction();
		EquipeDaoImpl eq = new EquipeDaoImpl();
		
		Employe e = new Employe(id,name,pren,role,email,pass,daten,eq.findById(code));
	

		s.save(e);

		s.getTransaction().commit();
		s.close();
		
	}

	
}
