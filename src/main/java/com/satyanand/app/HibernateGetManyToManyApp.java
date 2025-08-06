package com.satyanand.app;

import com.satyanand.model.CourseTable;
import com.satyanand.model.StudentTable;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateGetManyToManyApp {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(StudentTable.class)
                .addAnnotatedClass(CourseTable.class)
                .buildSessionFactory();

        Session session = null;

        try{
            session = sessionFactory.openSession();
            StudentTable st = session.find(StudentTable.class, 1);
            StudentTable st1 = session.find(StudentTable.class, 2);
            System.out.println(st);
            System.out.println(st.getCourses());
            System.out.println(st1);

            session.close();
            sessionFactory.close();

        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
