package com.example.hibernateAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.print.attribute.standard.Finishings;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class ManyToMany {

	static SessionFactory factory;

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(com.example.hibernateAnnotations.QuestionMM.class);
			cfg.addAnnotatedClass(com.example.hibernateAnnotations.AnswersMM.class);
			cfg.configure();
			factory = cfg.configure().buildSessionFactory();
			Session session = factory.openSession();
			tx = session.beginTransaction();

			// Many to many

			QuestionMM question1 = new QuestionMM("What is JAVA?");

			List<AnswersMM> answers = new ArrayList<AnswersMM>();

			AnswersMM answer1 = new AnswersMM("JAVA is prog lang", "Dimitar");
			AnswersMM answer2 = new AnswersMM("JAVA is proggraming lang", "Tom");

			answers.add(answer1);
			answers.add(answer2);

			question1.setAnswers(answers);
			
			
			QuestionMM question2 = new QuestionMM("What is servlet?");
			
			List<AnswersMM> answers2 = new ArrayList<AnswersMM>();

			AnswersMM answer3 = new AnswersMM("Servlet is interface", "Dimitar");
			AnswersMM answer4 = new AnswersMM("Servlet is API", "Tom");

			answers2.add(answer3);
			answers2.add(answer4);

			question2.setAnswers(answers2);

			// many-to-many relation is using session.persist
			session.persist(question1);
			session.persist(question2);

			tx.commit();
			session.close();

		} catch (HibernateException e) {
			System.out.println(e);
			tx.rollback();
		}

	}

}
