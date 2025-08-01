package com.satyanand.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.satyanand.model.Student;

public class LaunchHibernateStandardApp {
	public static void main(String[] args) {
		
		Configuration configuration = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		
		configuration = new Configuration();
		configuration.configure();
		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		
		
		Student student = new Student();
		student.setSid(3);
		student.setsName("Raj");
		student.setsCity("Darbhanga");
		
		try {
			
			transaction = session.beginTransaction();
			session.persist(student);
			flag = true;
			
		}catch (HibernateException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			if(flag == true) {
				transaction.commit();
			}
			else {
				transaction.rollback();
			}
			
			session.close();
		}
		
	}

}
