package com.ensa.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class test {

	public static void main(String[] args) {
		
		SessionFactory factory= HibernateUtil.getFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		session.getTransaction().commit();
		session.close();
		factory.close();
		

		
		
		
	}

}
