package com.ensa.dao.impl;

import java.lang.module.Configuration;

import javax.servlet.jsp.jstl.core.Config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.ensa.entity.Employe;

public class HibernateUtil {
	private static SessionFactory factory=null;
	public static SessionFactory getFactory(){ if (factory==null){
		StandardServiceRegistry registre=
		new StandardServiceRegistryBuilder().configure().build();
		factory=new MetadataSources(registre). buildMetadata(). buildSessionFactory();
		}
		return factory;
		}
	/*
	public static SessionFactory getConnection() {
		if (factory == null) {
			factory = new org.hibernate.cfg.Configuration().addAnnotatedClass(Employe.class).buildSessionFactory();
			return factory;
		}else return factory;
	}
	*/
}
