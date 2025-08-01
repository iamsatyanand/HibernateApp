package com.satyanand.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.satyanand.model.Student;



public class LaunchHibernateApp {

	public static void main(String[] args) {
		
		// Step 1: Configuration object creation
		Configuration config = new Configuration();
		
		// Step 2: configure hibernate.cfg.xml file to Configuration object
		config.configure();
		
		// Step 3: Create Session Factory object 
		SessionFactory sessionFactory = config.buildSessionFactory();
		
		//Step 4: Get the Session object from Session Factory
		Session session = sessionFactory.openSession();
		
		// Step 5: Begin Transaction within Session
		Transaction transaction = session.beginTransaction();
		
		Student student = new Student();
		student.setSid(1);
		student.setsCity("Darbhanga");
		student.setsName("Satya");
		
		// Step 6: Perform Operation
		session.persist(student);
		
		transaction.commit();
		
		session.close();
	}
}
