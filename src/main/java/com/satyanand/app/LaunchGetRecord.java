package com.satyanand.app;

import com.satyanand.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LaunchGetRecord {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = null;

        try {
            session = sessionFactory.openSession();
            Student st = session.find(Student.class, 1);
            Student student = session.getReference(Student.class, 3);
            System.out.println(st);
            System.out.println(student);
        }
        catch(HibernateException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        finally{
            session.close();
            sessionFactory.close();
        }
    }
}
