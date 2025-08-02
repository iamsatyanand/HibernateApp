package com.satyanand.app;

import com.satyanand.model.Answer;
import com.satyanand.model.Question;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class LaunchOnetoOneApp {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Question.class).addAnnotatedClass(Answer.class).buildSessionFactory();

        Session session = null;

        Transaction transaction = null;

        boolean flag = false;

        Question question = new Question();
        question.setId(1);
        question.setQuestion("what is hibernate framework");

        Answer answer = new Answer();
        answer.setId(1);
        answer.setAnswer("It is an ORM framework");

        question.setAnswer(answer);

        try {

            session = sessionFactory.openSession();
//            transaction = session.beginTransaction();
//            session.persist(question);
//            flag = true;
            Question qa = session.find(Question.class, 1);
            System.out.println(qa);

        } catch (HibernateException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        finally {
//            if(flag){
//                transaction.commit();
//            }
//            else{
//                transaction.rollback();
//            }
            session.close();
            sessionFactory.close();
        }

    }
}
