package com.satyanand.app;

import com.satyanand.model.AnswerTable;
import com.satyanand.model.QuestionTable;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class LaunchGetOneToManyApp {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(QuestionTable.class)
                .addAnnotatedClass(AnswerTable.class)
                .buildSessionFactory();

        Session session = null;




        try {
            session = sessionFactory.openSession();
            QuestionTable question = session.find(QuestionTable.class, 1);
//            System.out.println(question);
//            System.out.println(question.getAnswerList());
            System.out.println(question.getQuestion());
            session.close();
            sessionFactory.close();
            List<AnswerTable> answers = question.getAnswerList();
//            System.out.println(question);
            for(AnswerTable i : answers){
                System.out.println(i.toString());
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        finally {


        }



    }
}
