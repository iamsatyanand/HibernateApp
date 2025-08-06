package com.satyanand.app;

import com.satyanand.model.CourseTable;
import com.satyanand.model.StudentTable;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class HibernateManyToManyApp {

    public static void main(String[] args) {


       SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(StudentTable.class)
                .addAnnotatedClass(CourseTable.class).buildSessionFactory();

        Session session = null;

        Transaction transaction = null;

        boolean flag = true;


        CourseTable ct = new CourseTable();
        ct.setId(1);
        ct.setCourseName("Java programming");
        ct.setCoursePrice("5000");

        CourseTable ct2 = new CourseTable();
        ct2.setId(2);
        ct2.setCourseName("Data Structure");
        ct2.setCoursePrice("7000");

        Set<CourseTable> courses = new HashSet<>();
        courses.add(ct);
        courses.add(ct2);

        Set<CourseTable> course2 = new HashSet<>();
        course2.add(ct);


        StudentTable st = new StudentTable();
        st.setId(1);
        st.setName("Satyanand");
        st.setCity("Darbhanga");
        st.setCourses(courses);

        StudentTable st2 = new StudentTable();
        st2.setId(2);
        st2.setName("Siddhu");
        st2.setCity("Pune");
        st2.setCourses(course2);

        try {

         session = sessionFactory.openSession();

         transaction = session.beginTransaction();

         session.persist(st);
         session.persist(st2);
         flag = true;

        } catch (HibernateException e) {
         e.printStackTrace();
        } catch (Exception e) {
         e.printStackTrace();
        }

        finally {
         if(flag){
          transaction.commit();
         }
         else{
          transaction.rollback();
         }
         session.close();
         sessionFactory.close();
        }


    }
}
