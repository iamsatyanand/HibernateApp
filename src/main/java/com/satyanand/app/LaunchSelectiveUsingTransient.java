package com.satyanand.app;

import com.satyanand.model.Employee1;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LaunchSelectiveUsingTransient {

    public static void main(String[] args) {

       SessionFactory sessionFactory = new Configuration().configure()
                .addAnnotatedClass(Employee1.class).buildSessionFactory();

        Session session = null;

        Transaction transaction = null;

        boolean flag = false;

        try {

            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Employee1 emp = new Employee1();
            emp.setEid(1);
            emp.seteName("Satyanand");
            emp.setAge(24);

            // Even after explicitly mentioning city this attribute will not be added
            //  in the BD column because of Transeint annotation
            emp.seteCity("Darbhanga");

            session.persist(emp);
            flag = true;

        } catch (HibernateException e) {
            e.printStackTrace();
        } catch (Exception e){
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
