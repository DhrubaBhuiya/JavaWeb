package com.capgemini.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeeDAO {
	public void createEmployee(Employee emp){
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
	      
	      EntityManager entitymanager = emfactory.createEntityManager( );
	      entitymanager.getTransaction( ).begin( );

	      entitymanager.persist( emp );
	      entitymanager.getTransaction( ).commit( );

	      entitymanager.close( );
	      emfactory.close( );
	}
}
