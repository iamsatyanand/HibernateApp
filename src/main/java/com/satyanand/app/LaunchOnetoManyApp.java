package com.satyanand.app;


import com.satyanand.model.Answer;
import com.satyanand.model.AnswerTable;
import com.satyanand.model.QuestionTable;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class LaunchOnetoManyApp {

    public static void main(String[] args) {

       SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(QuestionTable.class)
                .addAnnotatedClass(AnswerTable.class)
                .buildSessionFactory();

        Session session = null;

        Transaction transaction = null;

        boolean flag = false;

        QuestionTable qt = new QuestionTable();
        qt.setId(1);
        qt.setQuestion("what is hibernate?");

        AnswerTable at = new AnswerTable();
        at.setId(1);
        at.setAnswer("It is an ORM framework.");
        at.setQuestion(qt);

        List<AnswerTable> answerList = new ArrayList<>();
        answerList.add(at);
        qt.setAnswerList(answerList);

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(qt);
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
            else {
                transaction.rollback();
            }
            session.close();
            sessionFactory.close();
        }


    }
}
