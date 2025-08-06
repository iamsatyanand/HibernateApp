package com.satyanand.app;

import com.satyanand.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateHQL1 {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = null;

        try{
            session = sessionFactory.openSession();
            Query<Student> query = session.createQuery("select s from Student s", Student.class);
            List<Student> students = query.list();
            students.forEach(System.out::println);
         } catch (HibernateException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
